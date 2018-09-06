package tmy.java.Bean;

import java.util.Date;

/**
 * Created by Zt on 2018.8.26
 * Bean数据传输层
 * 映射数据库blogvalue
 */
public class BlogMessage {
    private int messageId;
    private String messageComments;
    private String commentCritic;
    private String commentBelong;
    private String messageReplies;
    private Date commentDate;
    private Date RepliesDate;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageComments() {
        return messageComments;
    }

    public void setMessageComments(String messageComments) {
        this.messageComments = messageComments;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Date getRepliesDate() {
        return RepliesDate;
    }

    public void setRepliesDate(Date repliesDate) {
        RepliesDate = repliesDate;
    }

    public String getMessageReplies() {
        return messageReplies;
    }

    public void setMessageReplies(String messageReplies) {
        this.messageReplies = messageReplies;
    }

    public String getCommentCritic() {
        return commentCritic;
    }

    public void setCommentCritic(String commentCritic) {
        this.commentCritic = commentCritic;
    }

    public String getCommentBelong() {
        return commentBelong;
    }

    public void setCommentBelong(String commentBelong) {
        this.commentBelong = commentBelong;
    }
}
