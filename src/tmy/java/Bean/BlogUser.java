package tmy.java.Bean;

import java.util.Date;

/**
 * Created by Zt on 2018.8.7
 * Bean数据传输层
 * 映射数据库bloguser
 */

public class BlogUser{

    private int userId;//唯一标识编号
    private String loginName;//登陆名
    private String loginPassword;//登陆密码
    private String userName;//用户昵称
    private String userSex;//用户性别s
    private String userIntroduce;//个人简介
    private Date userBirth;//用户生日
    private String userWork;//工作
    private String userPhone;//手机号码
    private String userMail;//邮箱
    private String userAddress;//用户住址


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserWork() {
        return userWork;
    }

    public void setUserWork(String userWork) {
        this.userWork = userWork;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }



}
