package com.tinh.dev.myapplication.model;

public class HoaDon {
    private int STT;
    private String Ngay;

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public int getAnh() {
        return Anh;
    }

    public void setAnh(int anh) {
        Anh = anh;
    }

    public HoaDon(int STT, String ngay, int anh) {

        this.STT = STT;
        Ngay = ngay;
        Anh = anh;
    }

    private int Anh;
}
