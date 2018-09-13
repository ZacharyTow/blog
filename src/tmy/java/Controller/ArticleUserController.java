package tmy.java.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tmy.java.Bean.BlogArticle;
import tmy.java.Bean.BlogUser;
import tmy.java.Service.ArticleManageService;
import tmy.java.Service.ArticleUserService;
import tmy.java.Service.CookieManageService;
import tmy.java.Service.TimelineManageService;
import tmy.java.Bean.BlogBranch;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Zt on 2018.8.7
 * ArticleUserController主页控制器
 * 拦截符合要求的url映射，跳转至主页(登陆页面)
 */

@Controller
public class ArticleUserController {
    @Autowired
    @Qualifier("articleUserService")
    private ArticleUserService articleUserService;

    @Autowired
    @Qualifier("timelineManageService")
    private TimelineManageService timelineManageService;

    @Autowired
    @Qualifier("cookieManageService")
    private CookieManageService cookieManageService;

    @Autowired
    @Qualifier("articleManageService")
    private ArticleManageService articleManageService;

    //主页设置
    @RequestMapping(value = {"/","/home","/home/index"})
    public ModelAndView loginIndex() {
        ModelAndView modelAndView = new ModelAndView("login/loginIndex");
        return modelAndView;
    }

    //拦截login请求，处理登陆用户信息，并返回相应展示信息
    @RequestMapping("/login")
    public String login(HttpServletResponse response,String loginName, String loginPassword, RedirectAttributes attr, Model model) {
        BlogUser blogUser = articleUserService.checkLogin(loginName, loginPassword);
        String view = "";
        if (blogUser != null) {//登陆名与登陆密码无误
            attr.addFlashAttribute("userId",blogUser.getUserId());
            //更新cookie
            cookieManageService.setCookieByName(response,blogUser);
            view = "redirect:/article";
        } else {
            model.addAttribute("message", "登录名或者密码错误，请重新输入");
            view = "login/loginIndex";
        }

        return view;
    }

    //博客首页
    @RequestMapping("/article")
    public ModelAndView article(@ModelAttribute("userId") int userId){
        ModelAndView modelAndView = new ModelAndView("common/articleIndex");
        BlogUser blogUser = articleUserService.getUserById(userId);
        //获取该用户指定分支所有博文
        List<BlogArticle> blogArticles = articleManageService.getAllArticle(blogUser.getLoginName());
        //获取该用户推荐博文
        List<BlogArticle> blogArticlesRecommends = articleManageService.getAllArticleRecommend(blogUser.getLoginName());
        //分支展示
        List<BlogBranch> blogBranches = articleManageService.getAllBranch(blogUser.getLoginName());
        //点击量排行
        BlogArticle blogArticleReadedMax = articleManageService.getArticleReadesMax(blogUser.getLoginName());
        List<BlogArticle> blogArticleReadeds = articleManageService.getAllArticleReaded(blogUser.getLoginName());
        //特别推荐博文系列
        List<BlogArticle> blogArticleSpecials  = articleManageService.getAllArticleSpecial();
        modelAndView.addObject("blogUser", blogUser);
        modelAndView.addObject("blogArticles", blogArticles);
        modelAndView.addObject("blogArticlesRecommends", blogArticlesRecommends);
        modelAndView.addObject("branchName","All");
        modelAndView.addObject("blogBranches", blogBranches);
        modelAndView.addObject("blogArticleReadedMax", blogArticleReadedMax);
        modelAndView.addObject("blogArticleReadeds", blogArticleReadeds);
        modelAndView.addObject("blogArticleSpecials", blogArticleSpecials);
        return modelAndView;
    }
    //账户更新
    @RequestMapping(value = "/accountUpdate",method = RequestMethod.POST)
    @ResponseBody
    public String accountUpdate(@RequestBody JSONObject jsonObject){
        BlogUser blogUser = JSON.parseObject(jsonObject.toJSONString(),BlogUser.class);
        try{
            articleUserService.setUserById(blogUser);
        }catch (Exception e){
            timelineManageService.addTimelineInfo(blogUser.getLoginName(),
                    blogUser.getLoginName(),"更新用户信息","Fail");
            return "Update Fail";
        }
        timelineManageService.addTimelineInfo(blogUser.getLoginName(),
                blogUser.getLoginName(),"更新用户信息","Success");
        return "Update Success";

    }


    //注册用户
    @RequestMapping(value = "/accountRegister",method = RequestMethod.POST)
    @ResponseBody
    public String accountRegister(@RequestBody JSONObject jsonObject,HttpServletResponse response ){
        BlogUser blogUser = JSON.parseObject(jsonObject.toJSONString(),BlogUser.class);
        boolean flag = false;
        try{
            flag = articleUserService.addUserInfo(blogUser);
        }catch (Exception e){
            timelineManageService.addTimelineInfo(blogUser.getLoginName(),
                    blogUser.getLoginName(),"创建用户","Fail");
            return "Register Fail";
        }
        if(flag){
            //新建用户创建cookie
            cookieManageService.setCookieByName(response,blogUser);
            timelineManageService.addTimelineInfo(blogUser.getLoginName(),
                    blogUser.getLoginName(),"创建用户","Success");
            return "Register Success";
        }
        else
            return "Register Repeat";
    }

    //验证用户信息
    @RequestMapping(value = "/accountConfirm",method = RequestMethod.POST)
    @ResponseBody
    public String accountConfirm(@RequestBody JSONObject jsonObject) {
        BlogUser blogUser = JSON.parseObject(jsonObject.toJSONString(), BlogUser.class);
        BlogUser blogUserCheck = articleUserService.getUserByManager(blogUser.getLoginName());
        if(blogUserCheck == null){
            return "No Record:please check loginName";
        }else if(!(blogUserCheck.getUserMail().equals(blogUser.getUserMail()))){
            return "Mail Wrong:please check mail";
        }else if(!(blogUserCheck.getUserPhone().equals(blogUser.getUserPhone()))){
            return "Phone Wrong:please check phone";
        }
        return "Confirm Success";
    }
     //修改密码
     @RequestMapping(value = "/passwordUpdate",method = RequestMethod.POST)
     @ResponseBody
     public String passwordUpdate(String loginName,String password) {
        articleUserService.setPasswordByLoginName(loginName,password);
        return "Update Password Success";
     }

}
