package com.app.androidutildemo.db.dao.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.androidutildemo.db.dao.BookDao;
import com.app.androidutildemo.db.table.Book;
import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Nick on 2019-11-14.
 */
public class BookDaoImpl implements BookDao {

    private SQLiteDatabase mSQLiteDatabase;

    public BookDaoImpl(SQLiteDatabase sqLiteDatabase){
        mSQLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void saveBook(Book book) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",book.getId());
        contentValues.put("name",book.getName());
        long row = mSQLiteDatabase.insert("book", null, contentValues);
        if (row>0){
            LogUtils.i("insert book success");
        }else {
            LogUtils.i("insert error");
        }
    }

    @Override
    public Book getBookById(String id) {
        Cursor cursor = mSQLiteDatabase.query("book", new String[]{"id","name"}, "id=?", new String[]{id}, null, null, null);
        Book book = null;
        while (cursor.moveToNext()){
            book = new Book();
            book.setId(cursor.getString(cursor.getColumnIndex("id")));
            book.setName(cursor.getString(cursor.getColumnIndex("name")));
        }
        cursor.close();
        return book;
    }
}
