package vip.openpark.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author anthony
 * @since 2024/3/13 23:16
 */
@MapperScan("vip.openpark.mybatis.mapper")
@SpringBootApplication
public class MyBatisInterceptorApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyBatisInterceptorApplication.class, args);
	}
}