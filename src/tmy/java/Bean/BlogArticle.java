package tmy.java.Bean;

import java.util.Date;
/**
 * Created by Zt on 2018.8.7
 * Bean数据传输层
 * 映射数据库blogArticle
 */
public class BlogArticle {
    private int articleId;
    private String articleTitle;
    private String articleContent;
    private String articleAuthor;
    private String articleBelongBranch;
    private Date articleDate;
    private int articleReaded;
    private int articleLiked;
    private String articleManager;


    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleBelongBranch() {
        return articleBelongBranch;
    }

    public void setArticleBelongBranch(String articleBelongBranch) {
        this.articleBelongBranch = articleBelongBranch;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleManager() {
        return articleManager;
    }

    public void setArticleManager(String articleManager) {
        this.articleManager = articleManager;
    }

    public int getArticleReaded() {
        return articleReaded;
    }

    public void setArticleReaded(int articleReaded) {
        this.articleReaded = articleReaded;
    }

    public int getArticleLiked() {
        return articleLiked;
    }

    public void setArticleLiked(int articleLiked) {
        this.articleLiked = articleLiked;
    }
}
