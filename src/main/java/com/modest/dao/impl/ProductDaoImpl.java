package com.modest.dao.impl;

import com.modest.dao.ProductDao;
import com.modest.domain.Product;
import com.modest.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public class ProductDaoImpl implements ProductDao {
    private QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    @Override
    public Product getById(String id) throws Exception {
        String sql = "select * from product where pid = ?";
        return qr.query(sql,new BeanHandler<>(Product.class),id);
    }

    @Override
    public List<Product> findByPage(String cid, int currentPage, int pageSize) throws Exception {

        int count = (currentPage-1)*pageSize;
        String sql ="select * from product where cid = ? limit ?,? ";
        return qr.query(sql,new BeanListHandler<>(Product.class),cid,count,pageSize);
    }

    @Override
    public int getTotalCount(String cid) throws Exception {
        String sql = "select count(*) from product where cid = ?";

        return ((Long)qr.query(sql,new ScalarHandler<>(),cid)).intValue();
    }

    @Override
    public List<Product> findNew() throws Exception {
        String sql = "select * from product order by pdate limit 9";
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> findHot() throws Exception {
        String sql = "select * from product where is_hot = 1 limit 9";
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }

    /**
     *
     * @param ints 格式(1,2,3)
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findByIds(String ints) throws Exception {
        String sql = "select * from product where pid in "+ ints;
        return qr.query(sql ,new BeanListHandler<>(Product.class));
    }

}
