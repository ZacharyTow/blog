package tmy.java.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tmy.java.Bean.BlogArticle;
import tmy.java.Bean.BlogTimeline;
import tmy.java.Dao.TimelineManageDao;
import tmy.java.Service.TimelineManageService;

import java.util.List;
/**
 * Created by Zt on 2018.8.7
 * TimelineManageServiceImpl
 * 实现TimelineManageService功能
 */

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)  //表示数据库隔离级别为如果当前有就使用当前，如果没有就创建新的事务，
//隔离级别为：读已提交，也就是数据在写入的时候是无法被读的，只有提交后才能让其他事务读取，防止数据库发生脏读
@Service("timelineManageService")
public class TimelineManageServiceImpl implements TimelineManageService {
    @Autowired
    private TimelineManageDao timelineManageDao;

    @Override
    @Transactional(readOnly = true)
    public List<BlogTimeline> getAllByBelong(String timelineBelong){
        List<BlogTimeline> blogTimelines = timelineManageDao.findAllByBelong(timelineBelong);
        return blogTimelines;
    }

    @Override
    public int addTimelineInfo(String message,String belong, String option,String flag){
        BlogTimeline blogTimeline = combineParam(message,belong,option,flag);
        blogTimeline.setTimelineId(timelineManageDao.findPresentTimelineId()+1);
        return timelineManageDao.insertTimelineInfo(blogTimeline);
    }
    //时间轴参数组装
    private BlogTimeline combineParam(String message,String belong,String option,String flag) {
        BlogTimeline blogTimeline = new BlogTimeline();
        String timeLineTitle = option + "：" + message + "------->"+ flag;
        blogTimeline.setTimelineTitle(timeLineTitle);
        blogTimeline.setTimelineBelong(belong);
        return blogTimeline;
    }

}
