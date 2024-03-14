package vip.openpark.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import vip.openpark.mybatis.config.DataSourceEnum;
import vip.openpark.mybatis.config.DynamicDataSourceConfig;

/**
 * @author anthony
 * @since 2024/3/14 20:40
 */
@Intercepts({
	@Signature(type = Executor.class, method = "select", args = {MappedStatement.class}),
	@Signature(type = Executor.class, method = "update", args = {MappedStatement.class}),
})
public class DynamicDataSourcePlugin implements Interceptor {
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 获取当前执行方法的所有参数
		Object[] args = invocation.getArgs();
		// MappedStatement 封装了 CRUD 所有的元数据和 SQL
		MappedStatement ms = (MappedStatement) args[0];
		// 判断是否是查询
		if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
			DynamicDataSourceConfig.dataSourceType.set(DataSourceEnum.READ);
		} else {
			DynamicDataSourceConfig.dataSourceType.set(DataSourceEnum.WRITE);
		}
		return invocation.proceed();
	}
}