package com.tinh.dev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tinh.dev.myapplication.adapter.NodeSachAdapter;
import com.tinh.dev.myapplication.model.Book;

import java.util.ArrayList;

public class QLS_Activity extends AppCompatActivity {


    private RecyclerView recyclerviewS;
    private LinearLayoutManager linearLayoutManager;
    private NodeSachAdapter node_sachAdapter;
    private ArrayList<Book> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qls_);
        AnhXa();
        AddRecyclerview();

    }

    void AnhXa(){
        recyclerviewS =findViewById(R.id.recyclerviewS);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        arrayList=new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));
        arrayList.add(new Book("Tin học cơ sở",100,R.drawable.bookicon));


        node_sachAdapter =new NodeSachAdapter(this,arrayList);
    }

    void AddRecyclerview(){
        recyclerviewS.setLayoutManager(linearLayoutManager);
        recyclerviewS.setHasFixedSize(true);
        recyclerviewS.setAdapter(node_sachAdapter);
    }
}
