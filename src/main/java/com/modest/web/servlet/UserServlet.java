package com.modest.web.servlet;


import com.modest.constant.Constant;
import com.modest.converter.MyConverter;
import com.modest.domain.User;
import com.modest.service.UserService;
import com.modest.service.impl.UserServiceImpl;
import com.modest.utils.MD5Utils;
import com.modest.utils.MailUtils;
import com.modest.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 和用户相关的Servlet
 *
 * @author  modest
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 跳转注册页面的功能
     * @return 逻辑视图
     */
    public String registerUI(HttpServletRequest request,HttpServletResponse response){
        return "/jsp/register.jsp";
    }

    public String loginUI(HttpServletRequest request,HttpServletResponse response) {
        return "/jsp/login.jsp";
    }

    /**
     *
     * @param request 请求
     * @return 前端页面
     * @throws Exception 异常
     */
    public String register(HttpServletRequest request,HttpServletResponse response) throws Exception {

        //验证码逻辑

        //1、获取前台的页面中的验证码的内容
        String check = request.getParameter("check");

        //2、从服务器端session域中获取生成的验证码内容
        String sessionCode = (String)request.getSession().getAttribute("sessionCode");

        request.getSession().removeAttribute("sessionCode");

        if(sessionCode == null || !sessionCode.equalsIgnoreCase(check)){
            request.setAttribute("msg","验证码错误！！");
            return "/jsp/register.jsp";
        }

        //1、获取前台页面传递的参数
        Map<String,String[]> map = request.getParameterMap();

        //2、封装User/创建User对象，使用commons-beanUtils.jar
        User user = new User();

        //由于要封装日期对象，需要注册转换器，将字符串转换成Date对象
        ConvertUtils.register(new MyConverter(),Date.class);
        //这个方法会遍历map<key, value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性
        BeanUtils.populate(user,map);
        System.out.println(user);

        //1.1 设置用户id,由UUID.randomUUID().toString().replaceAll("-","")随机生成
        user.setUid(UUIDUtils.getId());

        //1.2 设置用户的激活码(唯一)
        user.setCode(UUIDUtils.getCode());

        //1.3 将密码加密
        user.setPassword(MD5Utils.md5(user.getPassword()));

        //2 调用UserService,注册用户
        userService.register(user);

        //3 获取用户注册邮箱
        String email = user.getEmail();

        //通过协议向注册邮箱发送激活信息
        MailUtils.sendMail(email,"请<a href='http://localhost:8080/user?method=active&code="+user.getCode()+" '>激活</a>用户邮箱","验证邮件");

        //提醒用户前往邮箱进行邮箱激活
        request.setAttribute("msg","请前往邮箱激活");
        return "/jsp/msg.jsp";
    }

    public String active(HttpServletRequest request,HttpServletResponse response) throws Exception {

        //1、获取激活码
        String code = request.getParameter("code");
        if(code != null){
            User user = userService.active(code);
            userService.updateStateByCode(user);
            request.setAttribute("msg","您当前已经激活,请<a href='http://localhost:8080/jsp/login.jsp'>登录</a>");
        }
        return "/jsp/msg.jsp";
    }


    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //1、获取前台的页面中的验证码的内容
        String check = request.getParameter("check");

        //2、从服务器端session域中获取生成的验证码内容
        String sessionCode = (String)request.getSession().getAttribute("sessionCode");

        if(sessionCode == null || !sessionCode.equalsIgnoreCase(check)){
            request.setAttribute("msg","验证码错误！！");
            return "/jsp/register.jsp";
        }
        //3 获取前台用户名及密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //4 调用Service查询用户
        User user = userService.findUserByNameAndPassword(username,MD5Utils.md5(password));

        if(user == null) {
            request.setAttribute("msg","用户名或密码不匹配");
            return "/jsp/msg.jsp";
        }else {

            if (user.getState() != Constant.ACTIVE_CODE_STATE) {
                request.setAttribute("msg", "当前用户尚未激活");
                return "/jsp/login.jsp";
            }

        }
        //若用户存在且激活，将用户存储到Session域中
        request.getSession().setAttribute("user",user);

        response.sendRedirect(request.getContextPath()+"/");
        return null;
    }


    /**
     *
     * 用户退出
     *
     * 删除存储在session域中的user信息
     *
     * @param request 请求
     * @param response 响应
     * @return null
     * @throws IOException 异常
     */
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/");
        return null;
    }


}
