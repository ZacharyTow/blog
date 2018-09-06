package tmy.java.Service;

import tmy.java.Bean.BlogUser;

/**
 * Created by Zt on 2018.8.7
 * ArticleUserService业务层
 * 包含Dao层对象，查询bloguser数据库
 */

public interface ArticleUserService {
    BlogUser checkLogin(String loginname, String password);

    BlogUser getUserById(int userId);

    BlogUser getUserByManager(String articleManager);

    int setUserById(BlogUser blogUser);

    boolean addUserInfo(BlogUser blogUser);

    int setPasswordByLoginName(String loginName, String password);
}

