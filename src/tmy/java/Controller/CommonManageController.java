package tmy.java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tmy.java.Bean.BlogArticle;
import tmy.java.Bean.BlogMessage;
import tmy.java.Bean.BlogTimeline;
import tmy.java.Bean.BlogUser;
import tmy.java.Service.ArticleManageService;
import tmy.java.Service.ArticleUserService;
import tmy.java.Service.MessageManageService;
import tmy.java.Service.TimelineManageService;

import java.util.List;

@Controller
public class CommonManageController {
    @Autowired
    @Qualifier("articleManageService")
    private ArticleManageService articleManageService;

    @Autowired
    @Qualifier("articleUserService")
    private ArticleUserService articleUserService;

    @Autowired
    @Qualifier("timelineManageService")
    private TimelineManageService timelineManageService;

    @Autowired
    @Qualifier("messageManageService")
    private MessageManageService messageManageService;
    //博客首页
    @RequestMapping("/articleIndex")
    public ModelAndView index(@RequestParam int userId){
        ModelAndView modelAndView = new ModelAndView("common/articleIndex");
        BlogUser blogUser = articleUserService.getUserById(userId);
        List<BlogArticle> blogArticles = articleManageService.getAllArticle(blogUser.getLoginName());
        modelAndView.addObject("blogUser", blogUser);
        modelAndView.addObject("blogArticles", blogArticles);
        return modelAndView;
    }
    //博文管理
    @RequestMapping("/articleManage")
    public ModelAndView articleManage(@RequestParam int userId){
        ModelAndView modelAndView = new ModelAndView("common/articleManage");
        BlogUser blogUser = articleUserService.getUserById(userId);
        List<BlogArticle> blogArticles = articleManageService.getAllArticle(blogUser.getLoginName());
        modelAndView.addObject("blogUser", blogUser);
        modelAndView.addObject("blogArticles", blogArticles);
        return modelAndView;
    }

    //留言板
    @RequestMapping("/messageBoard")
    public ModelAndView messageBoard(@RequestParam int userId){
        ModelAndView modelAndView = new ModelAndView("common/messageBoard");
        BlogUser blogUser = articleUserService.getUserById(userId);
        List<BlogMessage> blogMessages = messageManageService.getAllByManager(blogUser.getLoginName());
        modelAndView.addObject("blogUser", blogUser);
        modelAndView.addObject("blogMessages", blogMessages);
        return modelAndView;
    }

    //时间轴
    @RequestMapping("/traceTimeline")
    public ModelAndView traceTimeline(@RequestParam int userId){
        ModelAndView modelAndView = new ModelAndView("common/traceTimeline");
        BlogUser blogUser = articleUserService.getUserById(userId);
        List<BlogTimeline> blogTimelines = timelineManageService.getAllByBelong(blogUser.getLoginName());
        modelAndView.addObject("blogUser", blogUser);
        modelAndView.addObject("blogTimelines", blogTimelines);
        return modelAndView;
    }

    //账号管理
    @RequestMapping("/accountManage")
    public ModelAndView accountManage(@RequestParam int userId){
        ModelAndView modelAndView = new ModelAndView("common/accountManage");
        BlogUser blogUser = articleUserService.getUserById(userId);
        modelAndView.addObject("blogUser", blogUser);
        return modelAndView;
    }
    
}
