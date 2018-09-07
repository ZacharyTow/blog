package tmy.java.Service;

import tmy.java.Bean.BlogArticle;
import java.util.List;

/**
 * Created by Zt on 2018.8.7
 * ArticleManageService业务层
 * 包含Dao层对象，查询blogarticle数据库
 */

public interface ArticleManageService {
    //获取所有博文
    List<BlogArticle> getAllArticle(String loginName);
    //获取推荐博文
    List<BlogArticle> getAllArticleRecommend(String loginName);

    //根据id查找博文
    BlogArticle getArticleById(int articleId);
    //添加博文
    int addArticleInfo(BlogArticle blogArticle);
    //更新博文
    int renewalArticleById(BlogArticle blogArticle);
    //删除博文
    int removeArticleById(int articleId);

}
