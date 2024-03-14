package vip.openpark.multi.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vip.openpark.multi.domain.UserDO;
import vip.openpark.multi.mapper.read.RUserDOMapper;
import vip.openpark.multi.mapper.write.WUserDOMapper;

/**
 * @author anthony
 * @since 2024/3/14 21:20
 */
@Slf4j
@Service
public class UserService {
	@Resource
	private RUserDOMapper rUserDOMapper;
	@Resource
	private WUserDOMapper wUserDOMapper;
	
	public UserDO getUser(Long id) {
		return rUserDOMapper.selectByPrimaryKey(id);
	}
	
	public void saveUser(UserDO userDO) {
		wUserDOMapper.insertSelective(userDO);
	}
}