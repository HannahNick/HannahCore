package com.app.androidutildemo.db.dao;

import com.app.androidutildemo.db.table.User;

import java.util.List;

/**
 * Created by Nick on 2019-11-14.
 */
public interface UserDao {
    void saveUser(String id,String name,int age,String sex);
    List<User> getAllUser();
    User getUserById(String id);
    void updateUser(User u);
    void deleteUser(String id);
}
