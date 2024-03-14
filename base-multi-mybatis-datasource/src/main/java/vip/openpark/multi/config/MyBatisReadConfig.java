package vip.openpark.multi.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * 需要在 {@link MapperScan} 注解中指定 sqlSessionFactoryRef 属性
 *
 * @author anthony
 * @since 2024/3/14 21:53
 */
@Configuration
@MapperScan(basePackages = "vip.openpark.multi.mapper.read", sqlSessionFactoryRef = "readSqlSessionFactory")
public class MyBatisReadConfig {
	@Bean
	@ConfigurationProperties("spring.datasource.two")
	public DataSource dataSource2() {
		// 底层会自动将 spring.datasource 中的配置项注入到 DruidDataSource 中
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	public SqlSessionFactory readSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource2());
		return sqlSessionFactoryBean.getObject();
	}
}