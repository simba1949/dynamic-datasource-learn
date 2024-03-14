package vip.openpark.simple.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.openpark.simple.config.DataSourceEnum;
import vip.openpark.simple.config.DynamicDataSourceConfig;
import vip.openpark.simple.domain.UserDO;

import java.util.List;

/**
 * @author anthony
 * @since 2024/3/13 22:35
 */
@Slf4j
@SpringBootTest
public class UserDOMapperTest {
	@Resource
	private UserDOMapper userDOMapper;
	
	@Test
	public void selectAllTest() {
		// 设置数据源
		DynamicDataSourceConfig.dataSourceType.set(DataSourceEnum.WRITE);
		
		List<UserDO> dataList = userDOMapper.selectAll();
		log.info("dataList:{}", dataList.size());
		dataList.forEach(ele -> log.info("ele:{}", ele.toString()));
	}
}