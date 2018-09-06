package tmy.java.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tmy.java.Bean.BlogTimeline;

import java.util.List;
/**
 * Created by Zt on 2018.8.7
 * TimelineManageDao面向数据库
 * 执行SQL语句
 */
public interface TimelineManageDao {
    @Select("select * from BlogTimeline where timeline_belong = #{loginName} order by timeline_id desc")
    List<BlogTimeline> findAllByBelong(String timelineBelong);

    @Select("select max(timeline_id) from BlogTimeline")
    int findPresentTimelineId();

    @Insert("insert into BlogTimeline(timeline_id,timeline_title,timeline_date,timeline_belong) values(#{timelineId},#{timelineTitle},NOW(),#{timelineBelong})")
    int insertTimelineInfo(BlogTimeline blogTimeline);

}
