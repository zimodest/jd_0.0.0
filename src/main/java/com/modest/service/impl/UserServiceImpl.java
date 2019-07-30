package com.modest.service.impl;

import com.modest.dao.UserDao;
import com.modest.dao.impl.UserDaoImpl;
import com.modest.domain.User;
import com.modest.service.UserService;

/**
 * description
 *
 * @author modest
 * @date 2019/07/27
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();
    @Override
    public void register(User user) throws Exception {
        dao.register(user);
    }

    @Override
    public User active(String code) throws Exception {
        return dao.findUserByCode(code);
    }

    @Override
    public void updateStateByCode(User user)throws Exception {
        dao.updateStateByCode(user);
    }

    @Override
    public User findUserByNameAndPassword(String username, String password) throws Exception {
        return dao.findUserByNameAndPassword(username,password);
    }


}
