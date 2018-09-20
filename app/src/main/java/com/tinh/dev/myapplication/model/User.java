package com.tinh.dev.myapplication.model;

public class User {

    private String TenNguoiDung;
    private int AnhNguoiDung;
    private int SDT;

    public String getTenNguoiDung() {
        return TenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        TenNguoiDung = tenNguoiDung;
    }

    public int getAnhNguoiDung() {
        return AnhNguoiDung;
    }

    public void setAnhNguoiDung(int anhNguoiDung) {
        AnhNguoiDung = anhNguoiDung;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public User(String tenNguoiDung, int anhNguoiDung, int SDT) {

        TenNguoiDung = tenNguoiDung;
        AnhNguoiDung = anhNguoiDung;
        this.SDT = SDT;
    }
}
