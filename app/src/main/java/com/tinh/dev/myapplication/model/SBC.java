package com.tinh.dev.myapplication.model;

public class SBC {

    private String MaSach;
    private int SL;
    private int Anh;

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String maSach) {
        MaSach = maSach;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public int getAnh() {
        return Anh;
    }

    public void setAnh(int anh) {
        Anh = anh;
    }

    public SBC(String maSach, int SL, int anh) {

        MaSach = maSach;
        this.SL = SL;
        Anh = anh;
    }
}
