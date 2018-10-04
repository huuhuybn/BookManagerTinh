package com.tinh.dev.myapplication.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tinh.dev.myapplication.Constant;
import com.tinh.dev.myapplication.database.DatabaseHelper;
import com.tinh.dev.myapplication.model.Bill;

import java.util.ArrayList;
import java.util.List;


public class BillDAO implements Constant {

    private DatabaseHelper databaseHelper;

    public BillDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    public long insertBill(Bill bill) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(B_ID, bill.id);
        contentValues.put(B_DATE, bill.date);

        long result = sqLiteDatabase.insert(TABLE_BILL, null, contentValues);

        sqLiteDatabase.close();

        return result;
    }

    public long updateBill(Bill bill) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(B_DATE, bill.date);

        long result = sqLiteDatabase.update(TABLE_BILL, contentValues,
                B_ID + "=?", new String[]{bill.id});

        sqLiteDatabase.close();

        return result;

    }

    public long delBill(String id) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_BILL,
                B_ID + "=?", new String[]{id});

        sqLiteDatabase.close();

        return result;
    }

    public List<Bill> getAllBills() {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        List<Bill> bills = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_BILL,
                null);

        // kiem tra cursor co du lieu hay ko
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                // thiet lap con tro ve vi tri dau tien
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(0);
                    long date = cursor.getLong(1);

                    Bill bill = new Bill(id, date);

                    // them Bill vua lay duoc vao arraylist Bills
                    bills.add(bill);

                } while (cursor.moveToNext());
            }
            sqLiteDatabase.close();
        }

        return bills;

    }

    public Bill getBillByID(String id) {

        Bill bill = null;
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_BILL, new String[]{B_ID, B_DATE},
                B_ID + "=?",
                new String[]{id}, null, null, null);

        // kiem tra cursor co du lieu hay ko
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                // thiet lap con tro ve vi tri dau tien
                cursor.moveToFirst();
                String id_ = cursor.getString(0);
                long date = cursor.getLong(1);

                bill = new Bill(id, date);

                return bill;

            }
            sqLiteDatabase.close();
        }

        return null;
    }

}
