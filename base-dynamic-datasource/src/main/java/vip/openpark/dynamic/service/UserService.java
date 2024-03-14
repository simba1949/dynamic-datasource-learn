package vip.openpark.dynamic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vip.openpark.dynamic.domain.UserDO;
import vip.openpark.dynamic.mapper.UserDOMapper;

/**
 * @author anthony
 * @since 2024/3/14 23:28
 */
@Slf4j
@Service
public class UserService {
	@Resource
	private UserDOMapper userDOMapper;
	
	/**
	 * 读（read application.properties 配置的 read）
	 *
	 * @param id 用户id
	 * @return 用户
	 */
	@DS("read")
	public UserDO getUser(Long id) {
		return userDOMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 写（write application.properties 配置的 write）
	 *
	 * @param userDO 用户
	 */
	@DS("write")
	public void saveUser(UserDO userDO) {
		userDOMapper.insertSelective(userDO);
	}
}
