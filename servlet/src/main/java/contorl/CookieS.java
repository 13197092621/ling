package contorl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "CookieS",urlPatterns = "/cookie")
public class CookieS extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");//设置请求编码格式
        resp.setContentType("text/html;charset=utf-8");//设置相应编码格式
        Cookie cookie = new Cookie("le","la");//相应cookie信息
        cookie.setMaxAge(60*60*24*3);
        cookie.setPath("/getcookie");
        resp.addCookie(cookie);

    }
}
