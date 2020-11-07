package gaoji.gao.interceptor;


import gaoji.gao.entity.LoginTicket;
import gaoji.gao.entity.User;
import gaoji.gao.service.UserService;
import gaoji.gao.util.CookieUtil;
import gaoji.gao.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Description
 * @Author Zhang Shuaiyin
 * @Date 2020/07/12
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	UserService userService;
	@Autowired
	HostHolder hostHolder;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 从 cookie 中获取登录凭证
		String ticket = CookieUtil.getValue(request, "ticket");
		if (ticket != null) {
			// 查询凭证
			LoginTicket loginTicket = userService.findLoginTicket(ticket);
			// 检查凭证是否有效
			if (loginTicket != null && loginTicket.getStatus() == 0 && loginTicket.getExpires().after(new Date())) {
				// 根据凭证查询用户
				User user = userService.queryUserById(loginTicket.getUserId());
				// 在本次请求中持有用户--保存用户信息
				hostHolder.setUser(user);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
