package com.tinh.dev.myapplication;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tinh.dev.myapplication.adapter.NodeNguoiDungAdapter;
import com.tinh.dev.myapplication.database.DatabaseHelper;
import com.tinh.dev.myapplication.model.User;
import com.tinh.dev.myapplication.sqlitedao.UserDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListUserActivity extends AppCompatActivity {
    private RecyclerView recyclerviewNguoiDung;
    private LinearLayoutManager linearLayoutManager;
    private NodeNguoiDungAdapter node_nguoiDungAdapter;
    private List<User> users;


    private DatabaseHelper databaseHelper;
    private UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung_);


        AnhXa();
        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDAO(databaseHelper);


        for (int i = 0; i < 100; i++) {
            User user = new User(
                    "huynh " + new Random().nextInt(),
                    "admin123",
                    "Huy Nguyen " + new Random().nextInt(),
                    0,
                    "0919030190");

            userDAO.insertUser(user);
        }


        AddRecyclerview();


    }

    void AnhXa() {

        recyclerviewNguoiDung = findViewById(R.id.recyclerview_NguoiDung);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        users = new ArrayList<>();
        users.clear();
    }

    void AddRecyclerview() {


        users = userDAO.getAllUsers();
        node_nguoiDungAdapter = new NodeNguoiDungAdapter(this, users, userDAO);

        recyclerviewNguoiDung.setLayoutManager(linearLayoutManager);
        recyclerviewNguoiDung.setHasFixedSize(true);
        recyclerviewNguoiDung.setAdapter(node_nguoiDungAdapter);
    }

    public void addUser(View view) {

        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Add User");

        dialog.setContentView(R.layout.dialog_add_user);

        final EditText edtPassWord;
        EditText edtConfirmPassword;
        final EditText edtName;
        final EditText edtPhone;
        final EditText edtUserName;

        edtUserName = dialog.findViewById(R.id.edtUserName);
        edtPassWord = dialog.findViewById(R.id.edtPassWord);
        edtConfirmPassword = dialog.findViewById(R.id.edtConfirmPassword);
        edtName = dialog.findViewById(R.id.edtName);
        edtPhone = dialog.findViewById(R.id.edtPhone);


        dialog.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setUsername(edtUserName.getText().toString().trim());
                user.setTenNguoiDung(edtName.getText().toString().trim());
                user.setSDT(edtPhone.getText().toString().trim());
                user.setPassword(edtPassWord.getText().toString().trim());

                userDAO.insertUser(user);

                // cap nhat len giao dien
                // add vao vi tri dau tien
                users.add(0,user);
                node_nguoiDungAdapter.notifyDataSetChanged();


                Toast.makeText(ListUserActivity.this,
                        getString(R.string.notify_add_successful), Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        dialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }
}
