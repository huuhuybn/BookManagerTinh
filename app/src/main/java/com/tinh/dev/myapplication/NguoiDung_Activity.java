package com.tinh.dev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tinh.dev.myapplication.adapter.NodeNguoiDungAdapter;
import com.tinh.dev.myapplication.model.User;

import java.util.ArrayList;

public class NguoiDung_Activity extends AppCompatActivity {
    private RecyclerView recyclerviewNguoiDung;
    private LinearLayoutManager linearLayoutManager;
    private NodeNguoiDungAdapter node_nguoiDungAdapter;
    private ArrayList<User> arrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung_);
        AnhXa();
        AddRecyclerview();
    }

    void AnhXa(){
        recyclerviewNguoiDung =findViewById(R.id.recyclerview_NguoiDung);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        arrayList=new ArrayList<>();
        arrayList.clear();
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emone,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emthree,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emtwo,15455785));
//
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emone,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emthree,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emtwo,15455785));
//
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emone,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emthree,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emtwo,15455785));
//
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emone,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emthree,15455785));
//        arrayList.add(new User("Nguyễn Tình",R.drawable.emtwo,15455785));
//        node_nguoiDungAdapter =new NodeNguoiDungAdapter(this,arrayList);
        }

       void AddRecyclerview(){
           recyclerviewNguoiDung.setLayoutManager(linearLayoutManager);
           recyclerviewNguoiDung.setHasFixedSize(true);
           recyclerviewNguoiDung.setAdapter(node_nguoiDungAdapter);
        }
}
