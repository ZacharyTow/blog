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
import tmy.java.Bean.BlogUser;
import tmy.java.Service.ArticleManageService;
import tmy.java.Service.ArticleUserService;

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
    public String login(String loginName, String loginPassword, RedirectAttributes attr, Model model) {
        BlogUser blogUser = articleUserService.checkLogin(loginName, loginPassword);
        String view = "";
        if (blogUser != null) {//登陆名与登陆密码无误
            attr.addAttribute("userId",blogUser.getUserId());
            view = "redirect:/articleIndex";
        } else {
            model.addAttribute("message", "登录名或者密码错误，请重新输入");
            view = "login/loginIndex";
        }

        return view;
    }

    //账户更新
    @RequestMapping(value = "/accountUpdate",method = RequestMethod.POST)
    @ResponseBody
    public String accountUpdate(@RequestBody JSONObject jsonObject){
        BlogUser blogUser = JSON.parseObject(jsonObject.toJSONString(),BlogUser.class);
        articleUserService.renewalUserById(blogUser);
        return "update success";
    }


    //注册用户
    @RequestMapping(value = "/accountRegister",method = RequestMethod.POST)
    @ResponseBody
    public String accountRegister(@RequestBody JSONObject jsonObject){
        BlogUser blogUser = JSON.parseObject(jsonObject.toJSONString(),BlogUser.class);

        if(articleUserService.addUserInfo(blogUser) == false)
            return "repeat loginName";
        return "register success";
    }

}
