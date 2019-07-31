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
     * @throws Exception SQLException
     */
    Product getById(String id) throws Exception;

    /**
     * 根据分类id和当前页面大小当前页面查询商品
     * @param cid 分类id
     * @param currentPage 当前页码
     * @param pageSize 页面大小
     * @return 商品列表
     * @throws Exception SQLException
     */
    List<Product> findByPage(String cid, int currentPage, int pageSize) throws Exception;

    /**
     * 查询商品数量
     * @param cid 分类id
     * @return 商品数量
     * @throws Exception SQLException
     */
    int getTotalCount(String cid) throws Exception;

    /**
     * 查询最新商品
     * @return 商品列表
     * @throws Exception SQLException
     */
    List<Product> findNew() throws Exception;

    /**
     * 查询最热商品
     * @return 商品列表
     * @throws Exception SQLException
     */
    List<Product> findHot() throws Exception;

    /**
     * 查询保存在cookie中商品
     * @param ints pid字符串
     * @return 商品集合
     * @throws Exception SQLException
     */
    List<Product> findByIds(String ints) throws Exception;
}
