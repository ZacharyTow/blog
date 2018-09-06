package tmy.java.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tmy.java.Bean.BlogArticle;
import tmy.java.Bean.BlogUser;
import tmy.java.Service.ArticleManageService;
import tmy.java.Service.ArticleUserService;
import tmy.java.Service.TimelineManageService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zt on 2018.8.7
 * ArticleManageController主页控制器
 * 拦截符合要求的url映射，进行处理
 */

@Controller
public class ArticleManageController {
    @Autowired
    @Qualifier("articleManageService")
    private ArticleManageService articleManageService;

    @Autowired
    @Qualifier("articleUserService")
    private ArticleUserService articleUserService;

    @Autowired
    @Qualifier("timelineManageService")
    private TimelineManageService timelineManageService;


    //博文详情
    @RequestMapping("/articleViews")
    public ModelAndView view(@RequestParam  int articleId){
        ModelAndView modelAndView = new ModelAndView("article/articleViews");
        BlogArticle blogArticle = articleManageService.getArticleById(articleId);
        BlogUser blogUser = articleUserService.getUserByManager(blogArticle.getArticleManager());
        modelAndView.addObject("blogUser",blogUser);
        modelAndView.addObject("blogArticle",blogArticle);
        return modelAndView;
    }

    //博文添加页面
    @RequestMapping("/articleCreate")
    public ModelAndView articleCreate(@RequestParam int userId){
        ModelAndView modelAndView = new ModelAndView("article/articleCreate");
        BlogUser blogUser = articleUserService.getUserById(userId);
        modelAndView.addObject("blogUser", blogUser);
        return modelAndView;
    }
    //添加博客确认
    @RequestMapping(value = "/articleCreateConfirm",method = RequestMethod.POST)
    @ResponseBody
    public String articleCreateConfirm(@RequestBody JSONObject jsonObject){
        BlogArticle blogArticle = JSON.parseObject(jsonObject.toJSONString(),BlogArticle.class);
        try{
            articleManageService.addArticleInfo(blogArticle);
        }catch (Exception e){
            timelineManageService.addTimelineInfo(blogArticle.getArticleTitle(),
                    blogArticle.getArticleManager(),"添加博客","Fail");
            return "Add Fail";
        }
        timelineManageService.addTimelineInfo(blogArticle.getArticleTitle(),
                blogArticle.getArticleManager(),"添加博客","Success");
        return "Add Success";
    }


    //博文更新页面
    @RequestMapping("/articleUpdate")
    public ModelAndView articleUpdate(@RequestParam int articleId){
        ModelAndView modelAndView = new ModelAndView("article/articleUpdate");
        BlogArticle blogArticle = articleManageService.getArticleById(articleId);
        BlogUser blogUser = articleUserService.getUserByManager(blogArticle.getArticleManager());
        modelAndView.addObject("blogUser", blogUser);
        modelAndView.addObject("blogArticle", blogArticle);
        return modelAndView;
    }

    //更新博客确认
    @RequestMapping(value = "/articleUpdateConfirm",method = RequestMethod.POST)
    @ResponseBody
    public String articleUpdateConfirm(@RequestBody JSONObject jsonObject){
        BlogArticle blogArticleNew = JSON.parseObject(jsonObject.toJSONString(),BlogArticle.class);
        try{
            articleManageService.renewalArticleById(blogArticleNew);
        }catch (Exception e){
            timelineManageService.addTimelineInfo(blogArticleNew.getArticleTitle(),
                    blogArticleNew.getArticleManager(),"更新博客","Fail");
            return "Update Fail";
        }
        timelineManageService.addTimelineInfo(blogArticleNew.getArticleTitle(),
                blogArticleNew.getArticleManager(),"更新博客","Success");
        return "Update Success";

    }

    //博文删除
    @RequestMapping("/deleteConfirm")
    @ResponseBody
    public String deleteConfirm(HttpServletRequest request){
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        BlogArticle blogArticle = articleManageService.getArticleById(articleId);
        try{
            articleManageService.removeArticleById(articleId);
        }catch (Exception e){
            timelineManageService.addTimelineInfo(blogArticle.getArticleTitle(),
                    blogArticle.getArticleManager(),"删除博客","Fail");
            return "Delete Fail";
        }
        timelineManageService.addTimelineInfo(blogArticle.getArticleTitle(),
                blogArticle.getArticleManager(),"删除博客","Success");
        return "Delete Success";
    }

}
