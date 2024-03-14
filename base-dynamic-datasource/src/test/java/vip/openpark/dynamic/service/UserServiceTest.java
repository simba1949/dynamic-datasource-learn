package vip.openpark.dynamic.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.openpark.dynamic.domain.UserDO;

/**
 * @author anthony
 * @since 2024/3/14 23:29
 */
@Slf4j
@SpringBootTest
public class UserServiceTest {
	@Resource
	private UserService userService;
	
	@Test
	public void getUserTest() {
		UserDO user = userService.getUser(12L);
		log.info("{}", user.toString());
	}
	
	@Test
	public void saveUserTest() {
		UserDO userDO = new UserDO();
		userDO.setCode("save-code-" + 2);
		userDO.setUsername("save-username-" + 2);
		userDO.setPassword("save-password-" + 2);
		
		userService.saveUser(userDO);
	}
}
