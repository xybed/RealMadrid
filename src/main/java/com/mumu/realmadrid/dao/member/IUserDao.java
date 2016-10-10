package com.mumu.realmadrid.dao.member;

import com.mumu.realmadrid.pojo.member.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 7mu on 2016/6/27.
 */
@Repository("userDao")
public interface IUserDao {
    User getUserById(String id);
}
