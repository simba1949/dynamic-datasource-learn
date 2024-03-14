package vip.openpark.aop.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * spring 容器需要注入一个 datasource 的数据源，
 * 数据源中没有 datasource 名称则会报错，
 * 此时则需要通过注解 {@link Primary} 指定主数据源
 *
 * @author anthony
 * @since 2024/3/14 19:44
 */
@Primary
@Component
public class DynamicDataSourceConfig extends AbstractRoutingDataSource {
	// 用于切换数据源
	public static final ThreadLocal<DataSourceEnum> dataSourceType = new ThreadLocal<>();
	
	@Resource
	@Qualifier("dataSource1")
	private DataSource dataSource1;
	@Resource
	@Qualifier("dataSource2")
	private DataSource dataSource2;
	
	/**
	 * 重写该方法，返回当前数据源的key
	 *
	 * @return
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceType.get();
	}
	
	@Override
	public void afterPropertiesSet() {
		// 为 targetDataSources 初始化所有数据源
		Map<Object, Object> map = new HashMap<>();
		map.put(DataSourceEnum.READ, dataSource1);
		map.put(DataSourceEnum.WRITE, dataSource2);
		super.setTargetDataSources(map);
		
		// 为 defaultTargetDataSource 设置默认的数据源
		super.setDefaultTargetDataSource(dataSource1);
		
		super.afterPropertiesSet();
	}
}