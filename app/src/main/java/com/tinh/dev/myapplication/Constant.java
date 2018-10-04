package com.tinh.dev.myapplication;

public interface Constant {
    /*Bang User*/
    // Ten Bang
    String TABLE_USER = "User";

    // Ten Cot
    String COLUMN_USERNAME = "userName";
    String COLUMN_PASSWORD = "Password";
    String COLUMN_PHONE = "Phone";
    String COLUMN_NAME = "hoTen";

    // Cau lenh tao bang
    String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +

            COLUMN_USERNAME + " NVARCHAR(50) PRIMARY KEY," +

            COLUMN_PASSWORD + " NVARCHAR(30)," +

            COLUMN_PHONE + " NVARCHAR," +

            COLUMN_NAME + " NVARCHAR" +

            ")";

    /*Bang Book*/


    /*Bang Book TypeBook*/

    // CREATE TABLE TypeBook (MaTheLoai CHAR(5) PRIMARY KEY NOT NULL,
    // typeName NVARCHAR(50) NOT NULL, Description NVARCHAR(255), Position INT)


    // Ten bang
    String TABLE_TYPE_BOOK = "typeBook";

    // Ten cot

    String TB_COLUMN_ID = "MaTheLoai";
    String TB_COLUMN_NAME = "typeName";
    String TB_COLUMN_DES = "Description";
    String TB_COLUMN_POS = "Position";


    String CREATE_TABLE_TYPE_BOOK = "CREATE TABLE " + TABLE_TYPE_BOOK + "(" +
            "" + TB_COLUMN_ID + " CHAR(5) PRIMARY KEY NOT NULL," +
            "" + TB_COLUMN_NAME + " NVARCHAR(50) NOT NULL," +
            "" + TB_COLUMN_DES + " NVARCHAR(255)," +
            "" + TB_COLUMN_POS + " INT" +
            ")";


    // BILL (INVOICE) TABLE

    // CREATE TABLE Bill (MaHoaDon NCHAR(7) PRIMARY KEY NOT NULL, NgayMua LONG NOT NULL)

    String TABLE_BILL = "Bill";

    // khai bao cac cot
    String B_ID = "MaHoaDon";
    String B_DATE = "NgayMua";

    // khai bao bien' tao bang Bill
    String CREATE_TABLE_BILL = "CREATE TABLE " + TABLE_BILL + "(" +
            "" + B_ID + " NCHAR(7) PRIMARY KEY NOT NULL," +
             "" + B_DATE + " LONG NOT NULL" +
            ")";



}
