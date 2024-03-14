package vip.openpark.simple.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.openpark.simple.config.DataSourceEnum;
import vip.openpark.simple.config.DynamicDataSourceConfig;
import vip.openpark.simple.domain.UserDO;

/**
 * 用于初始化数据
 *
 * @author anthony
 * @since 2024/3/13 22:39
 */
@Slf4j
@SpringBootTest
public class InitDataTest {
	@Resource
	private UserDOMapper userDOMapper;
	
	@Test
	public void initData() {
		// 设置数据源
		DynamicDataSourceConfig.dataSourceType.set(DataSourceEnum.WRITE);
		
		for (int i = 0; i < 10; i++) {
			UserDO userDO = new UserDO();
			userDO.setCode("CODE-" + i);
			userDO.setUsername("USERNAME-" + i);
			userDO.setPassword("PASSWORD-" + i);
			
			int inserted = userDOMapper.insertSelective(userDO);
			Assertions.assertEquals(1, inserted, "insert failed");
		}
	}
}