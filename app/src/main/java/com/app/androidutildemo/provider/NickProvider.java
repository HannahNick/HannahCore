package com.app.androidutildemo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.app.androidutildemo.manager.DBManager;

/**
 * Created by Nick on 2019-11-15.
 */
public class NickProvider extends ContentProvider {

    public static final int TEST = 100;

    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        final String authority = TestContract.CONTENT_AUTHORITY;
        matcher.addURI(authority, TestContract.PATH_TEST, TEST);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection,  @Nullable String selection,@Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase sqLiteDatabase = DBManager.getInstance().getSQLiteDatabase();
        switch (matcher.match(uri)){
            case TEST:
                return sqLiteDatabase.query("user",projection,selection,selectionArgs,null,null,null);
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri,@Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri,@Nullable String selection,@Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri,@Nullable ContentValues values,  @Nullable String selection,@Nullable String[] selectionArgs) {
        return 0;
    }
}
