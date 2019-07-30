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

    Product getById(String id) throws Exception;

    PageBean<Product> findByPage(String cid, int currentPage, int pageSize) throws Exception;

    List<Product> finNew() throws Exception;

    List<Product> findHot() throws Exception;
}
