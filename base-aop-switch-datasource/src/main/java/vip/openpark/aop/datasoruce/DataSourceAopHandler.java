package vip.openpark.aop.datasoruce;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import vip.openpark.aop.config.DataSourceEnum;
import vip.openpark.aop.config.DynamicDataSourceConfig;

/**
 * @author anthony
 * @since 2024/3/14 21:22
 */
@Slf4j
@Aspect
@Component
public class DataSourceAopHandler {
	
	@Before("execution(* vip.openpark.aop.service.*.*(..)) && @annotation(dataSourceSwitch)")
	public void before(JoinPoint joinPoint, DataSourceSwitch dataSourceSwitch) {
		Signature signature = joinPoint.getSignature();
		log.info("方法:{}", signature.getName());
		
		DataSourceEnum dataSourceEnum = dataSourceSwitch.value();
		DynamicDataSourceConfig.dataSourceType.set(dataSourceEnum);
	}
}