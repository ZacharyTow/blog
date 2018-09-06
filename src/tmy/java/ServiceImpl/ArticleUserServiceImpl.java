package tmy.java.ServiceImpl;


/**
 * Created by Zt on 2018.8.7
 * ArticleUserServiceImpl
 * 实现ArticleUserService功能
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tmy.java.Bean.BlogUser;
import tmy.java.Dao.ArticleUserDao;
import tmy.java.Service.ArticleUserService;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)  //表示数据库隔离级别为如果当前有就使用当前，如果没有就创建新的事务，
//隔离级别为：读已提交，也就是数据在写入的时候是无法被读的，只有提交后才能让其他事务读取，防止数据库发生脏读
@Service("articleUserService")
public class ArticleUserServiceImpl implements ArticleUserService {

    @Autowired
    private ArticleUserDao articleUserDao;

    @Override
    @Transactional(readOnly = true)
    public BlogUser checkLogin(String loginName, String loginPassword){
        BlogUser blogUser = articleUserDao.findUserByLoginInfo(loginName, loginPassword);
        return blogUser;
    }

    @Override
    @Transactional(readOnly = true)
    public BlogUser getUserById(int userId){
        BlogUser blogUser = articleUserDao.findUserById(userId);
        return blogUser;
    }

    @Override
    @Transactional(readOnly = true)
    public BlogUser getUserByManager(String articleManager){
        BlogUser blogUser = articleUserDao.findArticleByManager(articleManager);
        return blogUser;
    }
    @Override
    public int renewalUserById(BlogUser blogUser){
        return articleUserDao.updateUserById(blogUser);
    }
    @Override
    public boolean addUserInfo(BlogUser blogUser){
        Boolean flag = true;
        blogUser.setUserId(articleUserDao.findPresentUserId()+1);
        if(articleUserDao.findArticleByManager(blogUser.getLoginName()) == null)
            articleUserDao.insertUserInfo(blogUser);
        else
            flag = false;
        return flag;
    }


}
