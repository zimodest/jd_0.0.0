package com.modest.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 *
 * 抽取的类
 *
 * @author zimodest
 */
@WebServlet(urlPatterns = "/base")
public class BaseServlet extends HttpServlet {

    /**
     * 重写HttpServlet中的service方法
     * 将protected--->public
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) {
        //反射的方式
        try {
            //1.获取子类
            Class clazz = this.getClass();

            //2.获取方法
            //method--->BaseServlet中子类的方法名
            String method = request.getParameter("method");

            if(method == null) {
                method = "index";
            }
            //3.调用方法
            Method m = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);

           //当前子类中的返回值String类型,页面跳转的路径
           String s = (String) m.invoke(this, request, response);
           //如果s==null
            if(s != null){
                //请求转发
                request.getRequestDispatcher(s).forward(request,response);
            }
        } catch (Exception e) {
           // e.printStackTrace(); 假设如果上面代码出现异常
            //抛出具体的异常 500/404
            throw new RuntimeException() ;
        }
    }
}
