package vip.openpark.aop.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vip.openpark.aop.domain.UserDO;

/**
 * @author anthony
 * @since 2024/3/14 21:32
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
		userDO.setCode("save-code-" + 1);
		userDO.setUsername("save-username-" + 1);
		userDO.setPassword("save-password-" + 1);
		
		userService.saveUser(userDO);
	}
}
