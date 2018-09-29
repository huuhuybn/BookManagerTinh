package com.tinh.dev.myapplication.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.tinh.dev.myapplication.Constant;
import com.tinh.dev.myapplication.database.DatabaseHelper;
import com.tinh.dev.myapplication.model.TypeBook;
import com.tinh.dev.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class TypeBookDAO implements Constant {


    private DatabaseHelper databaseHelper;

    public TypeBookDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public long insertTypeBook(TypeBook typeBook) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TB_COLUMN_ID, typeBook.id);
        contentValues.put(TB_COLUMN_NAME, typeBook.name);
        contentValues.put(TB_COLUMN_DES, typeBook.des);
        contentValues.put(TB_COLUMN_POS, typeBook.pos);

        // tao cau lenh insert

        long result = sqLiteDatabase.insert(TABLE_TYPE_BOOK, null, contentValues);

        Log.e("insertTypeBook", "insertTypeBook : " + result);

        sqLiteDatabase.close();

        return result;
    }

    public long updateTypeBook(TypeBook typeBook) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TB_COLUMN_NAME, typeBook.name);
        contentValues.put(TB_COLUMN_DES, typeBook.des);
        contentValues.put(TB_COLUMN_POS, typeBook.pos);

        long result = sqLiteDatabase.update(TABLE_TYPE_BOOK,
                contentValues, TB_COLUMN_ID + "=?",
                new String[]{typeBook.id});

        sqLiteDatabase.close();

        return result;
    }

    public long deleteTypeBook(String typeID) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_TYPE_BOOK,
                TB_COLUMN_ID + "=?", new String[]{typeID});

        sqLiteDatabase.close();

        return result;
    }

    public List<TypeBook> getAllTypeBooks() {

        List<TypeBook> typeBooks = new ArrayList<>();

        String SELECT_ALL_TYPE_BOOK = "SELECT * FROM " + TABLE_TYPE_BOOK;

        Log.e("getAllUsers", SELECT_ALL_TYPE_BOOK);

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_TYPE_BOOK, null);

        if (cursor.getCount() > 0){
            do {

                String id = cursor.getString(cursor.getColumnIndex(TB_COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(TB_COLUMN_NAME));
                String des = cursor.getString(cursor.getColumnIndex(TB_COLUMN_DES));
                String pos = cursor.getString(cursor.getColumnIndex(TB_COLUMN_POS));

                TypeBook typeBook = new TypeBook();
                typeBook.id = id;
                typeBook.name = name;
                typeBook.des = des;
                typeBook.pos = pos;

                // them user vao List< User >
                typeBooks.add(typeBook);


            } while (cursor.moveToNext());

        }
        cursor.close();
        sqLiteDatabase.close();

        return typeBooks;

    }

    public TypeBook getTypeBookByID(String typeID) {

        TypeBook typeBook = null;

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                new String[]{TB_COLUMN_DES, TB_COLUMN_ID, TB_COLUMN_NAME, TB_COLUMN_POS},
                TB_COLUMN_ID + "=?",
                new String[]{typeID}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {

            String id = cursor.getString(cursor.getColumnIndex(TB_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(TB_COLUMN_NAME));
            String des = cursor.getString(cursor.getColumnIndex(TB_COLUMN_DES));
            String pos = cursor.getString(cursor.getColumnIndex(TB_COLUMN_POS));

            typeBook = new TypeBook();
            typeBook.id = id;
            typeBook.name = name;
            typeBook.des = des;
            typeBook.pos = pos;

        }

        return typeBook;

    }

}
