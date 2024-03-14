package vip.openpark.multi.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * 需要在 {@link MapperScan} 注解中指定 sqlSessionFactoryRef 属性
 *
 * @author anthony
 * @since 2024/3/14 21:53
 */
@Configuration
@MapperScan(basePackages = "vip.openpark.multi.mapper.write", sqlSessionFactoryRef = "writeSqlSessionFactory")
public class MyBatisWriteConfig {
	@Bean
	@ConfigurationProperties("spring.datasource.one")
	public DataSource dataSource1() {
		// 底层会自动将 spring.datasource 中的配置项注入到 DruidDataSource 中
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public SqlSessionFactory writeSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource1());
		return sqlSessionFactoryBean.getObject();
	}
	
	/**
	 * 读库事务管理器
	 * 使用 {@link org.springframework.transaction.annotation.Transactional} 只能管理一个数据源，多数据源同时写时，出现异常只能有一个回滚
	 * 1.可以使用嵌套的编程式事务管理
	 * 2.可以使用嵌套的声明式事务管理
	 *
	 * @return 事务管理器
	 */
	@Bean
	@Primary
	public DataSourceTransactionManager readDataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource1());
		return dataSourceTransactionManager;
	}
}