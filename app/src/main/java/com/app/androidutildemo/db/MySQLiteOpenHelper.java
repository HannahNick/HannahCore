package com.app.androidutildemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Nick on 2019-11-13.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(@Nullable Context context,@Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        LogUtils.i("MySQLiteOpenHelper");
    }

    /**
     * 创建数据库时调用
     * 创建数据表
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtils.i("MySQLiteOpenHelper:onCreate");
    }

    /**
     * 数据库升级
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        LogUtils.i("MySQLiteOpenHelper:onUpgrade");
    }
}
