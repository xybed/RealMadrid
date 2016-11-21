package com.mumu.realmadrid.service.member;

import com.mumu.realmadrid.exception.RegisteredException;
import com.mumu.realmadrid.model.member.UserModel;
import com.mumu.realmadrid.pojo.member.User;

/**
 * Created by 7mu on 2016/6/27.
 */
public interface IUserService {
    User getUserById(String userId);
    UserModel register(String username, String password, String verifyCode) throws RegisteredException;
}
