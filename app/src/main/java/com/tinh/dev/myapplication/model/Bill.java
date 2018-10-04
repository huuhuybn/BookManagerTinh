package com.tinh.dev.myapplication.model;

public class Bill {
    public String id;
    // luu date duoi dang long - milissecond
    public long date;

    public Bill(String id, long date) {
        this.id = id;
        this.date = date;
    }

}
