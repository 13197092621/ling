package gaoji.gao.service;



import gaoji.gao.entity.LoginTicket;
import gaoji.gao.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ep流苏
 * @Date: 2020/6/14 10:37
 * @Description:
 */
public interface UserService {

	Integer activation(int userId, String code);
	public Map<String, Object> login(String username, String password, int expiredSecond) ;


	LoginTicket findLoginTicket(String ticket);

	User queryUserById(Integer userId);
}
