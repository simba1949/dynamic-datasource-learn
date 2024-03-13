package vip.openpark.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author anthony
 * @since 2024/3/13 22:25
 */
@MapperScan("vip.openpark.jdbc.mapper")
@SpringBootApplication
public class SpringJdbcApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}
}