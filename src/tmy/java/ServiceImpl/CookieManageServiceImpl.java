package tmy.java.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tmy.java.Bean.BlogUser;
import tmy.java.Service.CookieManageService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Zt on 2018.9.7
 * CookieManageServiceImpl
 */

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)  //表示数据库隔离级别为如果当前有就使用当前，如果没有就创建新的事务，
//隔离级别为：读已提交，也就是数据在写入的时候是无法被读的，只有提交后才能让其他事务读取，防止数据库发生脏读
@Service("cookieManageService")
public class CookieManageServiceImpl implements CookieManageService {
    @Override
    public void setCookieByName(HttpServletResponse response,BlogUser blogUser) {
        Cookie cookie = new Cookie(blogUser.getLoginName(),blogUser.getLoginPassword());
        cookie.setMaxAge(10);// 设置为30min
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public void removeCookieByName(HttpServletResponse response, Cookie cookie) {
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
