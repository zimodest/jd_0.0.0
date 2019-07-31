package com.modest.service.impl;

import com.modest.dao.ProductDao;
import com.modest.dao.impl.ProductDaoImpl;
import com.modest.domain.Category;
import com.modest.domain.PageBean;
import com.modest.domain.Product;
import com.modest.service.ProductService;
import com.modest.utils.CookUtils;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public Product getById(String id) throws Exception {
        return productDao.getById(id);
    }

    @Override
    public PageBean<Product> findByPage(String cid, int currentPage, int pageSize) throws Exception {
        int totalPage = 0;
        int totalCount  = productDao.getTotalCount(cid);
        if(totalCount%pageSize == 0) {
            totalPage = totalCount/pageSize;
        }else {
            totalPage = totalCount/pageSize +1;
        }
        List<Product> list = productDao.findByPage(cid,currentPage,pageSize);
        PageBean<Product> productPageBean = new PageBean<Product>(totalCount,currentPage,pageSize,list);
        productPageBean.setTotalPage(totalPage);

        return productPageBean;
    }

    @Override
    public List<Product> finNew() throws Exception{
        return productDao.findNew();
    }

    @Override
    public List<Product> findHot() throws Exception {
        return productDao.findHot();
    }

    @Override
    public List<Product> findByIds(String ints) throws Exception {

        String[] ins = ints.split("-");
        StringBuilder sql = new StringBuilder("(");
        for (int i=0; i<ins.length-1; i++) {
            sql.append(ins[i]).append(",");
        }
        sql.append(ins[ins.length - 1]).append(")");

        return productDao.findByIds(sql.toString());
    }
}
