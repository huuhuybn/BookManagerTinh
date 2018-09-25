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


    /*Bang Book Type*/




}
