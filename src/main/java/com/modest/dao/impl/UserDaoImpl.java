package com.modest.dao.impl;

import com.modest.dao.UserDao;
import com.modest.domain.User;
import com.modest.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * description
 *
 * @author modest
 * @date 2019/07/27
 */
public class UserDaoImpl implements UserDao {

    /**
     * 创建QueryRunner对象
     */
    private QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());


    @Override
    public void register(User user) throws Exception {
        //准备sql语句
        String sql = "insert into user values (?,?,?,?,?,?,?,?,?,?)";

        qr.update(sql,user.getUid(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getTelephone(),
                user.getBirthday(),
                user.getSex(),
                user.getState(),
                user.getCode());
    }

    @Override
    public User findUserByCode(String code) throws Exception {
        String sql = "select * from user where code = ? limit 1";
        return qr.query(sql,new BeanHandler<>(User.class),code);
    }

    @Override
    public void updateStateByCode(User user) throws Exception {
        String sql = "update user set state='1',code=null where code=?";
        qr.update(sql,user.getCode());
//        qr.update(sql,'1',null,user.getCode());
    }

    @Override
    public User findUserByNameAndPassword(String username, String password) throws Exception {

        String sql = "select * from user where username = ? and password = ?";
        return qr.query(sql,new BeanHandler<>(User.class),username,password);

    }


}
