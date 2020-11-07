package gaoji.gao.mapper;


import gaoji.gao.entity.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Zhang Shuaiyin
 * @Date 2020/07/05
 */
@Mapper
@Service
public interface LoginTicketMapper {


    int insertLoginTicket(LoginTicket loginTicket);

    LoginTicket selectByTicket(String ticket);

    int updateStatus(String ticket, int status);
}
