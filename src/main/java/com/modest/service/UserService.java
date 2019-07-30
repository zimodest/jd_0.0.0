package com.modest.service;

import com.modest.domain.User;

/**
 * description
 *
 * @author modest
 * @date 2019/07/27
 */
public interface UserService {

    void register(User user) throws Exception;

    User active(String code) throws Exception;

    void updateStateByCode(User user) throws Exception;

    User findUserByNameAndPassword(String username, String password)throws Exception;
}
