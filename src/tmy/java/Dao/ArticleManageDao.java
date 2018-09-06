package tmy.java.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tmy.java.Bean.BlogArticle;

import java.util.List;

/**
 * Created by Zt on 2018.8.7
 * ArticleManageDao面向数据库
 * 执行SQL语句
 */

public interface ArticleManageDao {
    @Select("select * from BlogArticle where article_manager = #{loginName} order by article_id desc")
    List<BlogArticle> findArticleByuUser(String loginName) ;

    @Select("select * from BlogArticle where article_id = #{articleId}")
    BlogArticle selectArticleById(int articleId);

    @Delete("delete from BlogArticle where article_id = #{articleId}")
    int deleteArticleById(int articleId);

    @Select("select max(article_id) from BlogArticle")
    int findPresentArticleId();

    @Insert("insert into BlogArticle(article_id,article_title,article_content,article_author,article_belong_branch,article_date,article_manager) " +
            "values(#{articleId},#{articleTitle},#{articleContent},#{articleAuthor},#{articleBelongBranch},NOW(),#{articleManager})")
    int insertArticleInfo(BlogArticle blogArticle);

    @Update("update BlogArticle set article_title = #{articleTitle},article_content = #{articleContent},article_belong_branch = #{articleBelongBranch}" +
            " where article_id = #{articleId}")
    int updateArticleById(BlogArticle blogArticle);
}
