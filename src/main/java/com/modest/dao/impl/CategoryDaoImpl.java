package com.modest.dao.impl;

import com.modest.dao.CategoryDao;
import com.modest.domain.Category;
import com.modest.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/24
 */
public class CategoryDaoImpl implements CategoryDao {

    private QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public List<Category> findAll() throws Exception {
        String sql = "select * from category";
        List<Category> list = qr.query(sql,new BeanListHandler<>(Category.class));
        System.out.println(list);
        return list;
    }
}
