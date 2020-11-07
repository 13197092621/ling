package gaoji.gao;

import gaoji.gao.entity.LoginTicket;
import gaoji.gao.mapper.LoginTicketMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Date;

@SpringBootTest
class GaoApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    LoginTicketMapper ticketMapper;

    @Test
    void getConnection() throws Exception {
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpires(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
        ticketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket() {
        LoginTicket abc = ticketMapper.selectByTicket("abc");
        System.out.println(abc);

        ticketMapper.updateStatus("abc", 1);
        abc = ticketMapper.selectByTicket("abc");
        System.out.println(abc);
    }


}
