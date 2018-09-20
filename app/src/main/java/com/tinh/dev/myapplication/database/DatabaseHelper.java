package com.tinh.dev.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.tinh.dev.myapplication.model.User;

public class DatabaseHelper extends SQLiteOpenHelper {


    // Ten Bang
    public static final String TABLE_USER = "User";

    // Ten Cot
    public static final String COLUMN_USERNAME = "userName";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_PHONE = "Phone";
    public static final String COLUMN_NAME = "hoTen";

    // Cau lenh tao bang
    public static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +

            COLUMN_USERNAME + " NVARCHAR PRIMARY KEY," +

            COLUMN_PASSWORD + " NVARCHAR," +

            COLUMN_PHONE + " NVARCHAR," +

            COLUMN_NAME + " NVARCHAR" +

            ")";


    public DatabaseHelper(Context context) {
        super(context, "BookManager", null, 1);
    }


    public void insertUser(User user) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

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

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                new String[]{COLUMN_USERNAME,COLUMN_PASSWORD,COLUMN_PHONE,COLUMN_NAME},
                COLUMN_USERNAME + "=?",
                new String[]{username},null,null,null);

        if (cursor !=null && cursor.moveToFirst()){

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


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);

    }
}
