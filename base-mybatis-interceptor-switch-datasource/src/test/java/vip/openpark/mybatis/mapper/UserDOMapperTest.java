package vip.openpark.mybatis.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.openpark.mybatis.domain.UserDO;

import java.util.List;

/**
 * @author anthony
 * @since 2024/3/14 20:48
 */
@Slf4j
@SpringBootTest
public class UserDOMapperTest {
	@Resource
	private UserDOMapper userDOMapper;
	
	@Test
	public void selectAllTest() {
		List<UserDO> dataList = userDOMapper.selectAll();
		log.info("dataList:{}", dataList.size());
		dataList.forEach(ele -> log.info("ele:{}", ele.toString()));
	}
	
	@Test
	public void updateByPrimaryKeySelectiveTest() {
		UserDO userDO = new UserDO();
		userDO.setId(1L);
		userDO.setPhone("13112341234");
		int count = userDOMapper.updateByPrimaryKeySelective(userDO);
		log.info("count:{}", count);
	}
}