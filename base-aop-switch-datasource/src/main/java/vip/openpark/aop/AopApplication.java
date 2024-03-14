package vip.openpark.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 注解 {@link EnableAspectJAutoProxy} 启用 aop 动态代理
 *
 * @author anthony
 * @since 2024/3/14 21:10
 */
@MapperScan("vip.openpark.aop.mapper")
@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {
	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}
}