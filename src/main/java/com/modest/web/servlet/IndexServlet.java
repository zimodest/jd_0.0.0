package com.modest.web.servlet;

import com.modest.domain.Category;
import com.modest.domain.Product;
import com.modest.service.CategoryService;
import com.modest.service.ProductService;
import com.modest.service.impl.CategoryServiceImpl;
import com.modest.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/29
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    private ProductService productService = new ProductServiceImpl();

    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //完成分类的获取
        List<Category> cList = categoryService.findAll();

        request.setAttribute("cList",cList);

        List<Product> nList = productService.finNew();
        List<Product> hList = productService.findHot();

        request.setAttribute("nList",nList);
        request.setAttribute("hList",hList);

        return  "/jsp/index.jsp";
    }
























}
