package tmy.java.Bean;

import java.util.Date;
/**
 * Created by Zt on 2018.8.26
 * Bean数据传输层
 * 映射数据库blogTimeline
 */
public class BlogTimeline {
    private int timelineId;
    private String timelineTitle;
    private Date timelineDate;
    private String timelineBelong;

    public int getTimelineId() {
        return timelineId;
    }

    public void setTimelineId(int timelineId) {
        this.timelineId = timelineId;
    }

    public String getTimelineTitle() {
        return timelineTitle;
    }

    public void setTimelineTitle(String timelineTitle) {
        this.timelineTitle = timelineTitle;
    }


    public String getTimelineBelong() {
        return timelineBelong;
    }

    public void setTimelineBelong(String timelineBelong) {
        this.timelineBelong = timelineBelong;
    }

    public Date getTimelineDate() {
        return timelineDate;
    }

    public void setTimelineDate(Date timelineDate) {
        this.timelineDate = timelineDate;
    }
}
