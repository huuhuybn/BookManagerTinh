package com.tinh.dev.myapplication.model;

public class Type {
    private int STT;
    private String TenLoai;
    private int Anh;

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }

    public int getAnh() {
        return Anh;
    }

    public void setAnh(int anh) {
        Anh = anh;
    }

    public Type(int STT, String tenLoai, int anh) {

        this.STT = STT;
        TenLoai = tenLoai;
        Anh = anh;
    }
}
