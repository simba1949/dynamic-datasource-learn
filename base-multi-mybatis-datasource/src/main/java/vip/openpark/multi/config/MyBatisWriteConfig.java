package vip.openpark.multi.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
}