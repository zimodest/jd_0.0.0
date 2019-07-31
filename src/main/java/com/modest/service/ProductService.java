package com.modest.service;

import com.modest.domain.PageBean;
import com.modest.domain.Product;

import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public interface ProductService {

    /**
     * 根据商品pid查询商品信息
     * @param id 所要查询的商品的pid
     * @return 所要查询的商品实体类
     * @throws Exception SQLException
     */
    Product getById(String id) throws Exception;

    /**
     * 根据当前商品分类、当前页面、每页显示商品数查询商品
     * @param cid 当前所要查询的商品的类别id
     * @param currentPage 当前访问的页数
     * @param pageSize 商品每页显示的数量
     * @return PageBean对象，保存查询到的商品集合，总记录数 总页数 当前页码 每页显示条数
     * @throws Exception SQLException
     */
    PageBean<Product> findByPage(String cid, int currentPage, int pageSize) throws Exception;

    /**
     *查询最新商品
     * @return 最新商品集合
     * @throws Exception SQLException
     */
    List<Product> finNew() throws Exception;


    /**
     * 查询最热商品
     * @return 最热商品集合
     * @throws Exception SQLException
     */
    List<Product> findHot() throws Exception;

    /**
     * 根据一组id查询商品
     * @param ints cookie中保存的商品的id字符串
     * @return 商品集合
     * @throws Exception SQLException
     */
    List<Product> findByIds(String ints) throws Exception;
}
