package com.modest.dao;

import com.modest.domain.Product;

import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public interface ProductDao {
    /**
     * 根据商品id查询商品
     * @param id 商品id
     * @return 商品列表
     * @throws Exception 异常
     */
    Product getById(String id) throws Exception;

    /**
     * 根据分类id和当前页面大小当前页面查询商品
     * @param cid 分类id
     * @param currentPage 当前页码
     * @param pageSize 页面大小
     * @return 商品列表
     * @throws Exception 异常
     */
    List<Product> findByPage(String cid, int currentPage, int pageSize) throws Exception;

    /**
     * 查询商品数量
     * @param cid 分类id
     * @return 商品数量
     * @throws Exception 异常
     */
    int getTotalCount(String cid) throws Exception;

    /**
     * 查询最新商品
     * @return 商品列表
     * @throws Exception 异常
     */
    List<Product> findNew() throws Exception;

    /**
     * 查询最热商品
     * @return 商品列表
     * @throws Exception 异常
     */
    List<Product> findHot() throws Exception;
}
