package gaoji.gao.service.impl;



import gaoji.gao.entity.LoginTicket;
import gaoji.gao.entity.User;
import gaoji.gao.mapper.UserMapper;
import gaoji.gao.service.UserService;
import gaoji.gao.util.CommunityConstant;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Ep流苏
 * @Date: 2020/6/14 10:37
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;

	@Override
	public Integer activation(int userId, String code) {
		User user = userMapper.queryUserById(userId);
		if (user.getStatus() == 1) {
			return CommunityConstant.ACTIVATION_REPEAT;
		} else if (user.getActivationCode().equals(code)) {
			userMapper.updateStatus(1, userId);
			return CommunityConstant.ACTIVATION_SUCCESS;
		} else {
			return CommunityConstant.ACTIVATION_FAILURE;
		}
	}

	@Override
	public Map<String, Object> login(String username, String password, int expiredSecond) {
		Map<String, Object> map = new HashMap<>(0);

		// 空值处理
		if (StringUtils.isBlank(username)) {
			map.put("usernameMsg", "用户名不能为空!");
			return map;
		}
		if (StringUtils.isBlank(password)) {
			map.put("passwordMsg", "密码不能为空!");
			return map;
		}
		return map;
	}

}