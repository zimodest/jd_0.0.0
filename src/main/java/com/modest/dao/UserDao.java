package com.modest.dao;

import com.modest.domain.User;

import java.sql.SQLException;

/**
 * description
 *
 * @author modest
 * @date 2019/07/27
 */
public interface UserDao {
    /**
     * 注册方法
     * @param user
     * @throws Exception SqlException
     */
    void register(User user) throws Exception;
    User findUserByCode(String code) throws Exception;

    void updateStateByCode(User code) throws Exception;

    User findUserByNameAndPassword(String username, String password) throws Exception;
}
