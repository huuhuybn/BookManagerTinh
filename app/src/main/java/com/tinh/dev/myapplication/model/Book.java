package com.tinh.dev.myapplication.model;

public class Book {

    private String TenSach;
    private int SoLuong;
    private int Anh;

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getAnh() {
        return Anh;
    }

    public void setAnh(int anh) {
        Anh = anh;
    }

    public Book(String tenSach, int soLuong, int anh) {

        TenSach = tenSach;
        SoLuong = soLuong;
        Anh = anh;
    }
}
