package com.modest.web.servlet;

import com.modest.domain.PageBean;
import com.modest.domain.Product;
import com.modest.service.ProductService;
import com.modest.service.impl.ProductServiceImpl;
import com.modest.utils.CookUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.modest.constant.Constant.GOODS_BROWSING_HISTORY_MAX_NUM;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
@WebServlet(urlPatterns = "/product")
public class ProductServlet extends BaseServlet {

    private ProductService productService = new ProductServiceImpl();

    /**
     * 根据商品编号获取商品信息
     * @param request 请求
     * @param response 响应
     * @return 前端页面
     * @throws Exception 异常
     */
    public String findById(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取url中商品类别ID pid 的参数
        String id = request.getParameter("pid");

        StringBuilder ids = new StringBuilder();

        //获取名为ids的空cookie，所浏览商品pid以字符串的形式保存在cookie中，每个pid之间用 - 作为分隔符（1-2-43）
        Cookie cookie = CookUtils.getCookieByName("ids",request.getCookies()) ;

        //cookie若为空，直接将所浏览的商品pid添加到ids中
        if(Objects.isNull(cookie)) {
            ids = new StringBuilder(id);
        } else {

            //cookie不为空，获取cookie中保存的商品pid字符串
            ids = new StringBuilder(cookie.getValue());

            //获取商品pid字符串中保存的商品pid，每个字符串就是一个pid
            String[] strings = ids.toString().split("-");

            //将字符串数组转成list
            List<String> asList = Arrays.asList(strings);
            LinkedList<String> list = new LinkedList<>(asList);

            //若正在访问的商品pid保存在cookie中，删除原有位置的该商品pid，添加到list的最前，保证最新访问的商品在前面
            if(list.contains(id)) {
                list.remove(id);
                list.addFirst(id);
            } else {

                //若cookie中保存的商品pid的个数大于cookie设定所能保存的最大个数时，将最久访问的数据删除(也就是将队为的删除)，
                // 将正在访问的商品pid插入到list的首部
                if(list.size() >= GOODS_BROWSING_HISTORY_MAX_NUM) {
                    list.removeLast();
                    list.addFirst(id);
                }else {
                    //若cookie中保存的商品pid的个数没有大于cookie设定所能保存的最大个数时，直接在队首插入正在访问的商品pid
                    list.addFirst(id);
                }
            }

            //将每个pid之间用 - 连接，重新放入到cookie中
            ids = new StringBuilder();
            for(String s:list) {
                ids.append(s).append("-");
            }
            ids = new StringBuilder(ids.substring(0, ids.length() - 1));
        }

        cookie = new Cookie("ids", ids.toString());
        response.addCookie(cookie);


        //查找浏览记录中的商品信息
        List<Product> goodsBrowsing = productService.findByIds(ids.toString());
        Product product = productService.getById(id);
        request.setAttribute("goodsBrowsing",goodsBrowsing);
        request.setAttribute("product",product);


        return  "/jsp/product_info.jsp";

    }

    //根据分类id分页查询商品数据

    public String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取url中的商品类别cid参数
        String cid = request.getParameter("cid");

        //获取url中的当前页面currentPage参数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        //每页显示商品数
        int pageSize = 12;

        //根据当前商品分类、当前页面、每页显示商品数查询商品
        PageBean<Product> pb = productService.findByPage(cid, currentPage,pageSize);

        //获取缓存浏览商品记录的cookie
        Cookie cookie = CookUtils.getCookieByName("ids",request.getCookies()) ;

        //根据cookies中存储的商品pid查询浏览记录中的商品
        if(!Objects.isNull(cookie)) {
            String ids = cookie.getValue();
            List<Product> goodsBrowsing = productService.findByIds(ids);
            request.setAttribute("goodsBrowsing",goodsBrowsing);
        }

        request.setAttribute("pb",pb);
        request.setAttribute("cid",cid);


        return "/jsp/product_list.jsp";
    }



    public String addCart(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取url中商品类别ID pid 的参数
        String id = request.getParameter("pid");

        StringBuilder ids = new StringBuilder();

        //获取名为ids的空cookie，所浏览商品pid以字符串的形式保存在cookie中，每个pid之间用 - 作为分隔符（1-2-43）
        Cookie cookie = CookUtils.getCookieByName("cart",request.getCookies()) ;

        //cookie若为空，直接将所浏览的商品pid添加到ids中
        if(Objects.isNull(cookie)) {
            ids = new StringBuilder(id);
        } else {

            //cookie不为空，获取cookie中保存的商品pid字符串
            ids = new StringBuilder(cookie.getValue());

            //获取商品pid字符串中保存的商品pid，每个字符串就是一个pid
            String[] strings = ids.toString().split("-");

            //将字符串数组转成list
            List<String> asList = Arrays.asList(strings);
            LinkedList<String> list = new LinkedList<>(asList);

            //若正在访问的商品pid保存在cookie中，删除原有位置的该商品pid，添加到list的最前，保证最新访问的商品在前面

            if(!list.contains(id)) {
                list.add(id);
            }
            for(String s:list) {
                ids.append(s).append("-");
            }
            ids = new StringBuilder(ids.substring(0, ids.length() - 1));
            //将每个pid之间用 - 连接，重新放入到cookie中

        }

        cookie = new Cookie("cart", ids.toString());
        response.addCookie(cookie);


        //查找浏览记录中的商品信息
        List<Product> cart = productService.findByIds(ids.toString());
        request.setAttribute("cart",cart);

        return  "/jsp/cart.jsp";

    }



}
