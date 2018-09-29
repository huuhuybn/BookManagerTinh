package com.tinh.dev.myapplication;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tinh.dev.myapplication.adapter.AdapterTypeBook;
import com.tinh.dev.myapplication.database.DatabaseHelper;
import com.tinh.dev.myapplication.model.TypeBook;
import com.tinh.dev.myapplication.sqlitedao.TypeBookDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QLLS_Activity extends AppCompatActivity {

    private RecyclerView lvListTypeBooks;
    private LinearLayoutManager linearLayoutManager;
    private AdapterTypeBook adapterTypeBook;
    private List<TypeBook> typeBooks;


    private DatabaseHelper databaseHelper;
    private TypeBookDAO typeBookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlls_);
        initViews();
        initData();
    }

    private void initData() {

        typeBooks = new ArrayList<>();
        typeBooks.clear();
        databaseHelper = new DatabaseHelper(this);
        typeBookDAO = new TypeBookDAO(databaseHelper);
        typeBooks = typeBookDAO.getAllTypeBooks();


        for (int i = 0; i < 20; i++) {
            TypeBook typeBook = new TypeBook();
            typeBook.id = new Random().nextInt() + "";
            typeBook.name = System.currentTimeMillis() + "";
            typeBook.pos = i + "";
            typeBook.des = "Hello Moto";

            typeBooks.add(typeBook);
        }

        adapterTypeBook = new AdapterTypeBook(this, typeBooks, typeBookDAO);
        lvListTypeBooks.setAdapter(adapterTypeBook);


    }

    private void initViews() {
        lvListTypeBooks = findViewById(R.id.recyclerviewLS);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lvListTypeBooks.setLayoutManager(linearLayoutManager);
        lvListTypeBooks.setHasFixedSize(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_type_book, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add_type_book) {

            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_add_type_book);

            final EditText edtID;
            final EditText edtName;
            final EditText edtDes;
            final EditText edtPos;
            Button btnAddTypeBook;
            Button btnCancel;

            edtID = dialog.findViewById(R.id.edtID);
            edtName = dialog.findViewById(R.id.edtName);
            edtDes = dialog.findViewById(R.id.edtDes);
            edtPos = dialog.findViewById(R.id.edtPos);
            btnAddTypeBook = dialog.findViewById(R.id.btnAddTypeBook);
            btnCancel = dialog.findViewById(R.id.btnCancel);


            btnAddTypeBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String id = edtID.getText().toString().trim();
                    String name = edtName.getText().toString().trim();
                    String des = edtDes.getText().toString().trim();
                    String pos = edtPos.getText().toString().trim();
                    TypeBook typeBook = new TypeBook(id, name, des, pos);

                    long result = typeBookDAO.insertTypeBook(typeBook);
                    if (result < 0) {
                        Toast.makeText(QLLS_Activity.this, "Ma Loai Sach Da Ton Tai", Toast.LENGTH_SHORT).show();
                    } else {
                        typeBooks.add(0, typeBook);

                        adapterTypeBook.notifyDataSetChanged();

                        Toast.makeText(QLLS_Activity.this, "Them loai sach thanh cong!!!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                }
            });

            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });
            dialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
