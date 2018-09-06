package tmy.java.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tmy.java.Bean.BlogUser;

/**
 * Created by Zt on 2018.8.7
 * ArticleUserDao面向数据库
 * 执行SQL语句
 */

public interface ArticleUserDao {
    @Select("select * from BlogUser where login_name = #{loginName} and login_password = #{loginPassword}")
    BlogUser findUserByLoginInfo(@Param("loginName")String loginName, @Param("loginPassword")String loginPassword);//@param表示上面sql中的参数

    @Select("select * from BlogUser where user_id = #{userId}")
    BlogUser findUserById(int userId);

    @Select("select * from BlogUser where login_name = #{articleManager}")
    BlogUser findArticleByManager(String articleManager);

    @Update("update BlogUser set login_password = #{loginPassword},user_name = #{userName},user_sex = #{userSex},user_introduce = #{userIntroduce}," +
            "user_birth = #{userBirth},user_work = #{userWork},user_phone = #{userPhone},user_mail = #{userMail},user_address = #{userAddress} " +
            "where user_id = #{userId}")
    int updateUserById(BlogUser blogUser);

    @Select("select max(user_id) from BlogUser")
    int findPresentUserId();

    @Insert("insert into BlogUser(user_id,login_name,login_password,user_name,user_phone)" +
            " values(#{userId},#{loginName},#{loginPassword},#{userName},#{userPhone}) ")
    int insertUserInfo(BlogUser blogUser);

    @Update("update BlogUser set login_password = #{password} where login_name = #{loginName}")
    int updatePasswordByLoginName(@Param("loginName") String loginName,@Param("password")String password);
}