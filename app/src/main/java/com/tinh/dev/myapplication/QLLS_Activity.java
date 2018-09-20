package com.tinh.dev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tinh.dev.myapplication.adapter.NodeLoaiSachAdapter;
import com.tinh.dev.myapplication.model.Type;

import java.util.ArrayList;

public class QLLS_Activity extends AppCompatActivity {

    private RecyclerView recyclerviewLS;
    private LinearLayoutManager linearLayoutManager;
    private NodeLoaiSachAdapter node_loaiSachAdapter;
    private ArrayList<Type> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlls_);
        AnhXa();
        AddRecyclerview();
    }

    void AnhXa(){
        recyclerviewLS =findViewById(R.id.recyclerviewLS);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        arrayList=new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Type(1,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(2,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(3,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(4,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(5,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(6,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(7,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(8,"Công nghệ thông tin",R.drawable.cateicon));
        arrayList.add(new Type(9,"Công nghệ thông tin",R.drawable.cateicon));

        node_loaiSachAdapter =new NodeLoaiSachAdapter(this,arrayList);
    }

    void AddRecyclerview(){
        recyclerviewLS.setLayoutManager(linearLayoutManager);
        recyclerviewLS.setHasFixedSize(true);
        recyclerviewLS.setAdapter(node_loaiSachAdapter);
    }
}
