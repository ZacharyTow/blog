package tmy.java.Dao;

import org.apache.ibatis.annotations.Select;
import tmy.java.Bean.BlogMessage;

import java.util.List;
/**
 * Created by Zt on 2018.8.26
 * MessageManageDao面向数据库
 * 执行SQL语句
 */

public interface MessageManageDao {
    @Select("select * from BlogMessage where comment_belong = #{loginName} order by message_id desc")
    List<BlogMessage> findAllByManager(String loginName);
}
