package cn.zou.shopping.controller;

import cn.zou.shopping.bean.Msg;
import cn.zou.shopping.bean.User;
import cn.zou.shopping.service.UserService;
import cn.zou.shopping.utils.CookieUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 邹创基 on 2018/5/17 11:02
 *
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 进入登录界面
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    /**
     * 用shiro提供的Realm拦截器来判断当前用户是否存在并授权
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/realm")
    public String test(String username, String password, Model model, HttpSession session) {
        //获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        //生成令牌(传入用户输入的账号和密码)
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //认证登录
        try {
            //这里会加载自定义的realm
            //把令牌放到login里面进行查询,如果查询账号和密码时候匹配,如果匹配就把user对象获取出来,失败就抛异常
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            //认证登录失败抛出异常
            model.addAttribute("message", "账号或密码错误或该账号已被管理员禁用");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            //认证登录失败抛出异常
            model.addAttribute("message", "账号或密码错误");
            return "login";
        }
        User loginUser = userService.selectByUsername(username);
        session.setAttribute("user", loginUser);
        return "redirect:/book/toindex";
    }

    /**
     * 登出
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(request, response,"user" );
        CookieUtil.deleteCookie(request, response,"ZouCart" );
        return "redirect:/user/loginPage";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/registerPage", method = {RequestMethod.GET})
    public String registerPage() {
        return "register/RegisterPage";
    }

    /**
     * 当用户无权限时跳转的页面
     * @param model
     * @return
     */
    @RequestMapping("/nopermission")
    public String nopermission(Model model) {
        model.addAttribute("message", "您无权访问该页面");
        return "commons/error";
    }

    /**
     * 跳转到添加购物车成功的界面
     * @return
     */
    @RequestMapping("/success")
    public String success() {
        return "cart/success";
    }

    /**
     * 检查当前用户名是否可用并以Json格式返回
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public Msg checkUserName(@RequestParam("username") String username) {
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if (!username.matches(regx)) {
            return Msg.fail().add("msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
        }
        //数据库用户名重复校验
        boolean b = userService.checkUser(username);
        if (b) {
            return Msg.success();
        } else {
            return Msg.fail().add("msg", "用户名不可用");
        }
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveUser(User user) {
        userService.saveUser(user);
        return Msg.success();
    }



}
