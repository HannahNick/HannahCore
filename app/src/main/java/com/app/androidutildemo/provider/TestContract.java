package com.app.androidutildemo.provider;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Nick on 2019-11-15.
 */
public class TestContract {
    public static final String CONTENT_AUTHORITY = "com.app.androidutildemo.nick";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_TEST = "query";
    public static final class TestEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TEST).build();
        protected static Uri buildUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        protected static final String TABLE_NAME = "test";

        public static final String COLUMN_NAME = "name";
    }

}
