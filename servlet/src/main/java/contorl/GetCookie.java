package contorl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "GetCookie",urlPatterns = "/getcookie")
public class GetCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置请求编码格式
        resp.setContentType("text/html;charset=utf-8");//设置相应编码格式
        Cookie[] cookies = req.getCookies();
        for (Cookie c:cookies) {
            String name = c.getName();
            String value = c.getValue();
            System.out.println(name+value);
        }
    }
}
