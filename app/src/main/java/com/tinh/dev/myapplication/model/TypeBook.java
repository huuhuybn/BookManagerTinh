package com.tinh.dev.myapplication.model;

public class TypeBook {
    public String id;
    public String name;
    public String des;
    public String pos;

    public TypeBook(String id, String name, String des, String pos) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.pos = pos;
    }

    public TypeBook() {
        // empty
    }
}
