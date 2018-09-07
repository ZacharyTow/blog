package tmy.java.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tmy.java.Bean.BlogArticle;
import tmy.java.Dao.ArticleManageDao;
import tmy.java.Service.ArticleManageService;


import java.util.List;

/**
 * Created by Zt on 2018.8.7
 * ArticleManageServiceImpl
 * 实现ArticleManageService功能
 */

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)  //表示数据库隔离级别为如果当前有就使用当前，如果没有就创建新的事务，
//隔离级别为：读已提交，也就是数据在写入的时候是无法被读的，只有提交后才能让其他事务读取，防止数据库发生脏读
@Service("articleManageService")
public class ArticleManageServiceImpl implements ArticleManageService {

    @Autowired
    private ArticleManageDao articleManageDao;

    @Override
    @Transactional(readOnly = true)
    public List<BlogArticle> getAllArticle(String loginName) {
        List<BlogArticle> blogArticles = articleManageDao.findArticleByuUser(loginName);
        return blogArticles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogArticle> getAllArticleRecommend(String loginName){
        List<BlogArticle> blogArticleRecommend = articleManageDao.findArticleRecommendByuUser(loginName);
        return blogArticleRecommend;
    }

    @Override
    @Transactional(readOnly = true)
    public BlogArticle getArticleReadesMax(String loginName){
        BlogArticle blogArticleReadedMax = articleManageDao.findArticleReadedMax(loginName);
        return blogArticleReadedMax;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogArticle> getAllArticleReaded(String loginName){
        List<BlogArticle> blogArticleReadeds = articleManageDao.findArticleReadedByuUser(loginName);
        return blogArticleReadeds;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogArticle> getAllArticleSpecial(){
        List<BlogArticle> blogArticleSpecials = articleManageDao.findArticleSpecial();
        return blogArticleSpecials;
    }

    @Override
    @Transactional(readOnly = true)
    public BlogArticle getArticleById(int articleId) {
        return articleManageDao.selectArticleById(articleId);
    }

    @Override
    public int removeArticleById(int articleId){
        int flag = articleManageDao.deleteArticleById(articleId);
        return flag;
    }

    @Override
    public int addArticleInfo(BlogArticle blogArticle){
        blogArticle.setArticleId(articleManageDao.findPresentArticleId()+1);
        blogArticle.setArticleReaded(0);
        blogArticle.setArticleLiked(0);
        return articleManageDao.insertArticleInfo(blogArticle);
    }

    @Override
    public int renewalArticleById(BlogArticle blogArticle){
        return articleManageDao.updateArticleById(blogArticle);
    }

}
