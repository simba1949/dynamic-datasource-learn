package vip.openpark.aop.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vip.openpark.aop.datasoruce.DataSourceSwitch;
import vip.openpark.aop.config.DataSourceEnum;
import vip.openpark.aop.domain.UserDO;
import vip.openpark.aop.mapper.UserDOMapper;

/**
 * @author anthony
 * @since 2024/3/14 21:20
 */
@Slf4j
@Service
public class UserService {
	@Resource
	private UserDOMapper userDOMapper;
	
	@DataSourceSwitch(DataSourceEnum.READ)
	public UserDO getUser(Long id) {
		return userDOMapper.selectByPrimaryKey(id);
	}
	
	@DataSourceSwitch(DataSourceEnum.WRITE)
	public void saveUser(UserDO userDO) {
		userDOMapper.insertSelective(userDO);
	}
}