package tmy.java.Dao;

import org.apache.ibatis.annotations.*;
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

    @Select("select * from BlogArticle where article_manager = #{loginName} order by article_liked desc limit 3")
    List<BlogArticle> findArticleRecommendByuUser(String loginName);

    @Select("select distinct article_belong_branch from BlogArticle where article_manager = #{loginName}")
    List<String> findAllBranchNameByUser(String loginName);

    @Select("select count(1) from BlogArticle where article_manager = #{loginName} and article_belong_branch = #{branchName}")
    int findCountByName(@Param("loginName") String loginName,@Param("branchName") String branchName);

    @Select("select * from BlogArticle where article_manager = #{loginName} order by article_readed desc limit 1")
    BlogArticle findArticleReadedMax(String loginName);

    @Select("select * from BlogArticle where article_manager = #{loginName} order by article_readed desc limit 1,4")
    List<BlogArticle> findArticleReadedByuUser(String loginName);

    @Select("select * from BlogArticle order by article_liked desc limit 3")
    List<BlogArticle> findArticleSpecial();

    @Select("select * from BlogArticle where article_id = #{articleId}")
    BlogArticle selectArticleById(int articleId);

    @Delete("delete from BlogArticle where article_id = #{articleId}")
    int deleteArticleById(int articleId);

    @Select("select max(article_id) from BlogArticle")
    int findPresentArticleId();

    @Insert("insert into BlogArticle(article_id,article_title,article_content,article_author,article_belong_branch,article_date,article_readed,article_liked,article_manager) " +
            "values(#{articleId},#{articleTitle},#{articleContent},#{articleAuthor},#{articleBelongBranch},NOW(),#{articleReaded},#{articleLiked},#{articleManager})")
    int insertArticleInfo(BlogArticle blogArticle);

    @Update("update BlogArticle set article_title = #{articleTitle},article_content = #{articleContent},article_belong_branch = #{articleBelongBranch}" +
            " where article_id = #{articleId}")
    int updateArticleById(BlogArticle blogArticle);



}
