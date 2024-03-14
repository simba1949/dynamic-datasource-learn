package vip.openpark.multi.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.openpark.multi.domain.UserDO;
import vip.openpark.multi.service.UserService;

/**
 * @author anthony
 * @since 2024/3/14 22:04
 */
@Slf4j
@SpringBootTest
public class UserMapperTest {
	
	@Resource
	private UserService userService;
	
	@Test
	public void getUserTest() {
		UserDO user = userService.getUser(1L);
		log.info("{}", user.toString());
	}
	
	@Test
	public void saveUserTest() {
		UserDO userDO = new UserDO();
		userDO.setCode("save-code-" + 1);
		userDO.setUsername("save-username-" + 1);
		userDO.setPassword("save-password-" + 1);
		
		userService.saveUser(userDO);
	}
}
