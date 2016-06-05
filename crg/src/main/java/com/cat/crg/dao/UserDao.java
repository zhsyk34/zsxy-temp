package com.cat.crg.dao;

import com.cat.crg.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archimedes on 2016/6/3.
 */
public class UserDao {

    public List<User> findList() {
        List<User> list = new ArrayList<>();

        User user;
        for (int i = 1; i <= 5; i++) {
            user = new User(i, "name" + i, "password" + (10 - i));
            list.add(user);
        }

        return list;
    }
}
