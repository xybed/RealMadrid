package com.mumu.realmadrid.service.member;

import com.mumu.realmadrid.common.Constants;
import com.mumu.realmadrid.dao.member.IUserDao;
import com.mumu.realmadrid.exception.RegisteredException;
import com.mumu.realmadrid.model.member.UserModel;
import com.mumu.realmadrid.pojo.member.User;
import lib.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 7mu on 2016/6/27.
 */
@Service("userService")
public class UserService implements IUserService{
    @Resource
    private IUserDao userDao;

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public UserModel register(String username, String password, String verifyCode) throws RegisteredException {
        if(userDao.validateRegisteredByUsername(username)){
            throw new RegisteredException("此帐号已注册过");
        }
        String registerDay = DateUtil.getNowDate();
        userDao.register(username, password, verifyCode, registerDay, Constants.DEFAULT_AVATAR);
        return userDao.getUserByUsername(username);
    }
}
