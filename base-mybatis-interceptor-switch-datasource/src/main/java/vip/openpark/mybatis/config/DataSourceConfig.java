package vip.openpark.mybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author anthony
 * @since 2024/3/13 22:49
 */
@Configuration
public class DataSourceConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource.one")
	public DataSource dataSource1() {
		// 底层会自动将 spring.datasource 中的配置项注入到 DruidDataSource 中
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.two")
	public DataSource dataSource2() {
		// 底层会自动将 spring.datasource 中的配置项注入到 DruidDataSource 中
		return DruidDataSourceBuilder.create().build();
	}
}