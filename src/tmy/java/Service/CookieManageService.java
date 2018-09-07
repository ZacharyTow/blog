package tmy.java.Service;

import tmy.java.Bean.BlogUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Zt on 2018.9.7
 * Cookie封装服务
 */

public interface CookieManageService {
    //更新cookie
    void setCookieByName( HttpServletResponse response, BlogUser blogUser);
    //删除cookie
    void removeCookieByName(HttpServletResponse response,Cookie cookie);
}
