package vip.openpark.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author anthony
 * @since 2024/3/14 23:17
 */
@MapperScan("vip.openpark.dynamic.mapper")
@SpringBootApplication
public class DynamicDataSourceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DynamicDataSourceApplication.class, args);
	}
}