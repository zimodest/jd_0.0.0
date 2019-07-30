package com.modest.web.servlet;

import com.modest.domain.Category;
import com.modest.service.CategoryService;
import com.modest.service.impl.CategoryServiceImpl;
import com.modest.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
@WebServlet(urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryServiceImpl();
    public void findAll(HttpServletRequest request, HttpServletResponse response ) throws Exception {


        //获取分类信息
        List<Category> cList = categoryService.findAll();

        //将cList集合存储到request域中
        request.setAttribute("cList",cList);

        //设置响应格式
        response.setContentType("application/json;charset=utf-8");

        System.out.println(cList);
        String json = JsonUtil.list2json(cList);
        System.out.println(json);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
    }
}
