package vip.openpark.aop.datasoruce;

import vip.openpark.aop.config.DataSourceEnum;

import java.lang.annotation.*;

/**
 * 使用 AOP + 自定义注解的方式适用于读写分离，也适用于不同业务不同场景的数据源切换
 *
 * @author anthony
 * @since 2024/3/14 21:14
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceSwitch {
	// 读写切换
	DataSourceEnum value() default DataSourceEnum.READ;
}