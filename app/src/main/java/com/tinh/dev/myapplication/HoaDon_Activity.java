package com.tinh.dev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tinh.dev.myapplication.adapter.NodeHoaDonAdapter;
import com.tinh.dev.myapplication.model.HoaDon;

import java.util.ArrayList;

public class HoaDon_Activity extends AppCompatActivity {
    private RecyclerView recyclerviewHD;
    private LinearLayoutManager linearLayoutManager;
    private NodeHoaDonAdapter node_loaiSach;
    private ArrayList<HoaDon> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_);
        AnhXa();
        AddRecyclerview();
    }
    void AnhXa(){
        recyclerviewHD =findViewById(R.id.recyclerviewHD);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        arrayList=new ArrayList<>();
        arrayList.clear();
        arrayList.add(new HoaDon(1,"05-09-1998",R.drawable.hdicon));
        arrayList.add(new HoaDon(1,"05-09-1998",R.drawable.hdicon));
        arrayList.add(new HoaDon(1,"05-09-1998",R.drawable.hdicon));
        arrayList.add(new HoaDon(1,"05-09-1998",R.drawable.hdicon));
        arrayList.add(new HoaDon(1,"05-09-1998",R.drawable.hdicon));
        arrayList.add(new HoaDon(1,"05-09-1998",R.drawable.hdicon));
        arrayList.add(new HoaDon(1,"05-09-1998",R.drawable.hdicon));


        node_loaiSach=new NodeHoaDonAdapter(this,arrayList);
    }

    void AddRecyclerview(){
        recyclerviewHD.setLayoutManager(linearLayoutManager);
        recyclerviewHD.setHasFixedSize(true);
        recyclerviewHD.setAdapter(node_loaiSach);
    }

}
