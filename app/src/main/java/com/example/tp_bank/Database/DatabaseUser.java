package com.example.tp_bank.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseUser extends SQLiteOpenHelper {
    public static final String DatabaseUSer_user = "user";
    public static final int veson = 1;

    public DatabaseUser(Context context) {
        super(context, DatabaseUSer_user, null, veson);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String insert_into = "INSERT INTO user(username,password)";
        String sql_user = "CREATE TABLE user(idUser integer primary key autoincrement,username text not null,password text not null )";
        sqLiteDatabase.execSQL(sql_user);
        sql_user = insert_into + "VALUES('admin','admin')";
        sqLiteDatabase.execSQL(sql_user);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
