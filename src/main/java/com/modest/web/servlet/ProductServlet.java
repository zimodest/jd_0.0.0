package com.modest.web.servlet;

import com.modest.domain.PageBean;
import com.modest.domain.Product;
import com.modest.service.ProductService;
import com.modest.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
@WebServlet(urlPatterns = "/product")
public class ProductServlet extends BaseServlet {

    private ProductService productService = new ProductServiceImpl();

    //根据商品编号获取商品信息
    public String findById(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("pid");
        Product product = productService.getById(id);
        request.setAttribute("product",product);
        return  "/jsp/product_info.jsp";

    }

    //根据分类id分页查询商品数据

    public String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String cid = request.getParameter("cid");

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        int pageSize = 12;
        PageBean<Product> pb = productService.findByPage(cid, currentPage,pageSize);

        request.setAttribute("pb",pb);
        request.setAttribute("cid",cid);

        return "/jsp/product_list.jsp";
    }
}
