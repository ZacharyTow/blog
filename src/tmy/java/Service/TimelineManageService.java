package tmy.java.Service;

import tmy.java.Bean.BlogArticle;
import tmy.java.Bean.BlogTimeline;

import java.util.List;
/**
 * Created by Zt on 2018.8.7
 * TimelineManageService业务层
 * 包含Dao层对象，查询blogtimeline数据库
 */
public interface TimelineManageService {
    //遍历时间轴展示
    List<BlogTimeline> getAllByBelong(String loginName);

    //记录操作博客时间轴
    int addTimelineInfo(BlogArticle blogArticle, String option,String flag);

}
