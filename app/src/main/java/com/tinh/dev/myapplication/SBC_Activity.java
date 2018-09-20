package com.tinh.dev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tinh.dev.myapplication.adapter.NodeSBCAdapter;
import com.tinh.dev.myapplication.model.SBC;

import java.util.ArrayList;

public class SBC_Activity extends AppCompatActivity {
    private RecyclerView recyclerview_SBC;
    private LinearLayoutManager linearLayoutManager;
    private NodeSBCAdapter node_loaiSach;
    private ArrayList<SBC> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbc);
        AnhXa();
        AddRecyclerview();
    }
    void AnhXa(){
        recyclerview_SBC =findViewById(R.id.recyclerview_SBC);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        arrayList=new ArrayList<>();
        arrayList.clear();
        arrayList.add(new SBC("S1",100,R.drawable.money_icon));
        arrayList.add(new SBC("S1",100,R.drawable.money_icon));
        arrayList.add(new SBC("S1",100,R.drawable.money_icon));
        arrayList.add(new SBC("S1",100,R.drawable.money_icon));
        arrayList.add(new SBC("S1",100,R.drawable.money_icon));
        arrayList.add(new SBC("S1",100,R.drawable.money_icon));
        arrayList.add(new SBC("S1",100,R.drawable.money_icon));
        node_loaiSach=new NodeSBCAdapter(this,arrayList);
    }

    void AddRecyclerview(){
        recyclerview_SBC.setLayoutManager(linearLayoutManager);
        recyclerview_SBC.setHasFixedSize(true);
        recyclerview_SBC.setAdapter(node_loaiSach);
    }

}
