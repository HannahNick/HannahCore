package com.app.androidutildemo.db;

/**
 * Created by Nick on 2019-11-13.
 */
public interface SQLConstants {

    String CREATE_USER = "create table if not exists user (\n" +
            "            id text primary key,\n" +
            "            name text,\n" +
            "            age integer,\n" +
            "            sex text\n" +
            "     );";

    String CREATE_TABLE = "create table if not exists book(\n" +
            "    id textz primary key,\n" +
            "    name text\n" +
            ")";

    String CHECK_ALL_USER = "select * from user";
}
