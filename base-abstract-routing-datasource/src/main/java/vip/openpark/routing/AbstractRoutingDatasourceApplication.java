package vip.openpark.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author anthony
 * @since 2024/3/14 19:25
 */
@MapperScan("vip.openpark.routing.mapper")
@SpringBootApplication
public class AbstractRoutingDatasourceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AbstractRoutingDatasourceApplication.class, args);
	}
}