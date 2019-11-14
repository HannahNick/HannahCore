package com.app.androidutildemo.db.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.app.androidutildemo.db.dao.UserDao;
import com.app.androidutildemo.db.table.User;
import com.blankj.utilcode.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 2019-11-14.
 */
public class UserDaoImpl implements UserDao {

    private SQLiteDatabase mSQLiteDatabase;

    public UserDaoImpl(SQLiteDatabase sqLiteDatabase){
        mSQLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void saveUser(String id, String name, int age, String sex) {
        try {
            mSQLiteDatabase.beginTransaction();
            ContentValues user = new ContentValues();
            user.put("id",id);
            user.put("name",name);
            user.put("age",age);
            user.put("sex",sex);
            long row = mSQLiteDatabase.insert("user", null, user);
            mSQLiteDatabase.setTransactionSuccessful();
            if (row>0){
                LogUtils.i("insert success");
            }else {
                LogUtils.i("insert error");
            }
        }catch (Exception e){
            LogUtils.e(e.getMessage());
        }finally {
            mSQLiteDatabase.endTransaction();
        }


    }

    @Override
    public List<User> getAllUser() {
        Cursor cursor = mSQLiteDatabase.query("user", null, null, null, null, null, null);
        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name =cursor.getString(cursor.getColumnIndex("name"));
            int age =cursor.getInt(cursor.getColumnIndex("age"));
            String sex =cursor.getString(cursor.getColumnIndex("sex"));
            User user = new User(id,name,age,sex);
            users.add(user);
        }
        cursor.close();
        return users;
    }

    @Override
    public User getUserById(String id) {
        Cursor cursor = mSQLiteDatabase.query("user", null, "id=?", new String[]{id}, null, null, null);
        User user = null;
        while (cursor.moveToNext()){
            String userId = cursor.getString(cursor.getColumnIndex("id"));
            if (TextUtils.isEmpty(userId)){
                return user;
            }
            String name =cursor.getString(cursor.getColumnIndex("name"));
            int age =cursor.getInt(cursor.getColumnIndex("age"));
            String sex =cursor.getString(cursor.getColumnIndex("sex"));
            user = new User(userId,name,age,sex);
        }
        cursor.close();
        return user;
    }

    @Override
    public void updateUser(User u) {
        try {
            mSQLiteDatabase.beginTransaction();
            String id = u.getId();
            String name = u.getName();
            Integer age = u.getAge();
            String sex = u.getSex();

            ContentValues user = new ContentValues();
            user.put("name",name);
            int row = mSQLiteDatabase.update("user", user, "id=?", new String[]{id});
            mSQLiteDatabase.setTransactionSuccessful();
            if (row>0){
                LogUtils.i("update success");
            }else {
                LogUtils.i("update error");
            }
        }catch (Exception e){
            LogUtils.e(e.getMessage());
        }finally {
            mSQLiteDatabase.endTransaction();
        }
    }

    @Override
    public void deleteUser(String id) {
        try {
            mSQLiteDatabase.beginTransaction();
            int row = mSQLiteDatabase.delete("user", "id=?", new String[]{id});
            mSQLiteDatabase.setTransactionSuccessful();
            if (row>0){
                LogUtils.i("delete success");
            }else {
                LogUtils.i("delete error");
            }
        }catch (Exception e){
            LogUtils.i(e.getMessage());
        }finally {
            mSQLiteDatabase.endTransaction();
        }
    }


}
