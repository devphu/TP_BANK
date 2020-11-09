package com.example.tp_bank.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tp_bank.Database.DatabaseUser;
import com.example.tp_bank.Model.User;

import java.util.ArrayList;

public class UserDao {

    DatabaseUser databaseUser;

    public UserDao(Context context) {
        databaseUser = new DatabaseUser(context);

    }

    public ArrayList<User> readAll() {
        ArrayList<User> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = databaseUser.getReadableDatabase();
        Cursor cs = sqLiteDatabase.rawQuery("select * from user", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            int idUser = cs.getInt(0);
            String username = cs.getString(1);
            String password = cs.getString(2);
            arrayList.add(new User(idUser, username, password));
            cs.moveToNext();
        }
        cs.close();
        return arrayList;
    }

    public long insert(User item) {
        SQLiteDatabase sqLiteDatabase = databaseUser.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idUser", item.getIdUser());
        contentValues.put("username", item.getUsername());
        contentValues.put("passwrod", item.getUsername());
        return sqLiteDatabase.insert("user", null, contentValues);
    }

    public int update(User item) {
        SQLiteDatabase sqLiteDatabase = databaseUser.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", item.getUsername());
        contentValues.put("password", item.getPassword());
        return sqLiteDatabase.update("user", contentValues, "id=?", new String[]{
                String.valueOf(item.getIdUser())
        });
    }

}
