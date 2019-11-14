package com.app.androidutildemo.ui.activity;

import android.view.View;
import android.widget.Button;

import com.app.androidutildemo.R;
import com.app.androidutildemo.db.table.Book;
import com.app.androidutildemo.db.table.User;
import com.app.androidutildemo.db.SQLConstants;
import com.app.androidutildemo.manager.DBManager;
import com.app.hannahcore.base.BaseActivity;
import com.app.hannahcore.base.BasePresenter;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;

import java.util.List;

public class SQLiteActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtn_create_db;
    private Button mBtn_save_user;
    private Button mBtn_show_user;
    private Button mBtn_update_user;
    private Button mBtn_delete_user;
    private Button mBtn_save_book;
    private Button mBtn_get_book;



    @Override
    protected int setLayout() {
        return R.layout.activity_sqlite;
    }

    @Override
    protected void findViews() {
        mBtn_create_db = findViewById(R.id.btn_create_db);
        mBtn_save_user = findViewById(R.id.btn_save_user);
        mBtn_show_user = findViewById(R.id.btn_show_user);
        mBtn_update_user = findViewById(R.id.btn_update_user);
        mBtn_delete_user = findViewById(R.id.btn_delete_user);
        mBtn_save_book = findViewById(R.id.btn_save_book);
        mBtn_get_book = findViewById(R.id.btn_get_book);
    }

    @Override
    protected void init() {
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .request();
    }

    @Override
    protected void initListener() {
        mBtn_create_db.setOnClickListener(this);
        mBtn_save_user.setOnClickListener(this);
        mBtn_show_user.setOnClickListener(this);
        mBtn_update_user.setOnClickListener(this);
        mBtn_delete_user.setOnClickListener(this);
        mBtn_save_book.setOnClickListener(this);
        mBtn_get_book.setOnClickListener(this);
    }

    @Override
    protected void release() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_db:
                createDb();
                break;
            case R.id.btn_save_user:
                saveUser();
                break;
            case R.id.btn_show_user:
                showAllUser();
                break;
            case R.id.btn_update_user:
                updateUser();
                break;
            case R.id.btn_delete_user:
                deleteUser();
                break;
            case R.id.btn_save_book:
                saveBook();
                break;
            case R.id.btn_get_book:
                getBook();
                break;
            default:
                break;
        }
    }

    private void createDb(){
        DBManager.getInstance().init(this);
        DBManager.getInstance().exqSql(SQLConstants.CREATE_USER);
    }

    private void saveUser(){
        DBManager.getInstance().getUserDao().saveUser("2","王大锤",28,"男");
    }

    private void showAllUser(){
        List<User> allUser = DBManager.getInstance().getUserDao().getAllUser();
        LogUtils.i(allUser.toString());
    }

    private void updateUser(){
        User user = DBManager.getInstance().getUserDao().getUserById("1");
        if (user!=null){
            user.setName("hannah");
            DBManager.getInstance().getUserDao().updateUser(user);
        }
    }

    private void deleteUser(){
        DBManager.getInstance().getUserDao().deleteUser("2");
    }

    private void saveBook(){
        Book book = new Book("1","礼物");
        DBManager.getInstance().getBookDao().saveBook(book);
    }

    private void getBook(){
        Book book = DBManager.getInstance().getBookDao().getBookById("1");
        LogUtils.i(book.toString());
    }


}
