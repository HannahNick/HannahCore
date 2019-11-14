package com.app.androidutildemo.manager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import com.app.androidutildemo.db.DBConstants;
import com.app.androidutildemo.db.MySQLiteOpenHelper;
import com.app.androidutildemo.db.SQLConstants;
import com.app.androidutildemo.db.dao.BookDao;
import com.app.androidutildemo.db.dao.UserDao;
import com.app.androidutildemo.db.dao.impl.BookDaoImpl;
import com.app.androidutildemo.db.dao.impl.UserDaoImpl;
import com.blankj.utilcode.util.LogUtils;

import java.util.List;

/**
 * Created by Nick on 2019-11-13.
 */
public class DBManager {

    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    private SQLiteDatabase mSQLiteDatabase;

    private UserDao mUserDao;
    private BookDao mBookDao;

    private DBManager(){}

    public void init(Context context){
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(context, DBConstants.DB_NAME,null,DBConstants.DB_VERSION);
        mSQLiteDatabase = mMySQLiteOpenHelper.getWritableDatabase();
        showDataBase(mSQLiteDatabase);
        try {
            mSQLiteDatabase.execSQL(SQLConstants.CREATE_USER);
            mSQLiteDatabase.execSQL(SQLConstants.CREATE_TABLE);
            mUserDao = new UserDaoImpl(mSQLiteDatabase);
            mBookDao = new BookDaoImpl(mSQLiteDatabase);
        }catch (SQLException e){
            LogUtils.i(String.format("创建表失败了>>>>%1$s,%2$s",e.getCause().toString(),e.getMessage()));
        }
    }

    public static DBManager getInstance(){
        return Holder.sManager;
    }

    public UserDao getUserDao(){
        return mUserDao;
    }

    public BookDao getBookDao() {
        return mBookDao;
    }

    private void showDataBase(SQLiteDatabase sqLiteDatabase){
        List<Pair<String, String>> attachedDbs = sqLiteDatabase.getAttachedDbs();
        for (int i = 0; i < attachedDbs.size(); i++) {
            Pair<String, String> pair = attachedDbs.get(i);
            LogUtils.i(String.format("%1$s=%2$s",pair.first,pair.second));
        }
    }

    public void exqSql(String sql){
        mSQLiteDatabase.execSQL(sql);
        LogUtils.i("创建表执行完成:");
    }


    private static class Holder{
        private static final DBManager sManager = new DBManager();
    }
}
