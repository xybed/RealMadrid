package com.mumu.realmadrid.service.member;

import com.mumu.realmadrid.dao.member.IUserDao;
import com.mumu.realmadrid.pojo.member.User;
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
}
