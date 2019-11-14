package com.app.androidutildemo.db.dao;

import com.app.androidutildemo.db.table.Book;

/**
 * Created by Nick on 2019-11-14.
 */
public interface BookDao {
    void saveBook(Book book);
    Book getBookById(String id);
}
