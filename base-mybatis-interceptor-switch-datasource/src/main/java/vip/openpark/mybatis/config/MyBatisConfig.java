package vip.openpark.mybatis.config;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.openpark.mybatis.plugin.DynamicDataSourcePlugin;

/**
 * @author anthony
 * @since 2024/3/14 20:55
 */
@Configuration
public class MyBatisConfig {
	
	@Bean
	public Interceptor dynamicDataSourcePlugin(){
		return new DynamicDataSourcePlugin();
	}
}