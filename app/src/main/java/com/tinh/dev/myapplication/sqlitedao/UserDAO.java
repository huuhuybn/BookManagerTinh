package com.tinh.dev.myapplication.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.tinh.dev.myapplication.Constant;
import com.tinh.dev.myapplication.database.DatabaseHelper;
import com.tinh.dev.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements Constant {


    private DatabaseHelper databaseHelper;

    public UserDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    public void insertUser(User user) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, user.getUsername());
        contentValues.put(COLUMN_PASSWORD, user.getPassword());
        contentValues.put(COLUMN_PHONE, user.getSDT());
        contentValues.put(COLUMN_NAME, user.getTenNguoiDung());

        // tao cau lenh insert

        long id = sqLiteDatabase.insert(TABLE_USER, null, contentValues);

        Log.e("insertUser", "insertUser : " + id);

        sqLiteDatabase.close();

    }

    public User getUserByUsername(String username) {

        User user = null;

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                new String[]{COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_PHONE, COLUMN_NAME},
                COLUMN_USERNAME + "=?",
                new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {

            String user_name = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));

            String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
            String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));

            user = new User();
            user.setUsername(user_name);
            user.setPassword(password);
            user.setTenNguoiDung(name);
            user.setSDT(phone);

        }

        return user;
    }

    public List<User> getAllUsers() {


        List<User> userList = new ArrayList<>();

        String SELECT_ALL_USER = "SELECT * FROM " + TABLE_USER;

        Log.e("getAllUsers", SELECT_ALL_USER);

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_USER, null);

        cursor.moveToFirst();

        do {

            String user_name = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
            String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));

            User user = new User();
            user.setUsername(user_name);
            user.setPassword(password);
            user.setTenNguoiDung(name);
            user.setSDT(phone);

            // them user vao List< User >
            userList.add(user);


        } while (cursor.moveToNext());

        cursor.close();
        sqLiteDatabase.close();

        return userList;
    }


    public int deleteUser(String username) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        return sqLiteDatabase.delete(TABLE_USER,
                COLUMN_USERNAME + "=?", new String[]{username});

    }

    public int updateUser(User user) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PASSWORD, user.getPassword());
        contentValues.put(COLUMN_PHONE, user.getSDT());
        contentValues.put(COLUMN_NAME, user.getTenNguoiDung());

        return sqLiteDatabase.update(TABLE_USER,
                contentValues, COLUMN_USERNAME + "=?",
                new String[]{user.getUsername()});

    }

}
