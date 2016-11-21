package com.mumu.realmadrid.dao.member;

import com.mumu.realmadrid.model.member.UserModel;
import com.mumu.realmadrid.pojo.member.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 7mu on 2016/6/27.
 */
@Repository("userDao")
public interface IUserDao {
    User getUserById(String id);
    boolean validateRegisteredByUsername(String username);
    void register(String username, String password, String verifyCode, String registerDay, String avatar);
    UserModel getUserByUsername(String username);
}
