package com.tinh.dev.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity{


    private EditText edtUserName,edtPassWord;
    private CheckBox ckbRememberPassword;
    private FloatingActionButton flbForMatText;
    private TextView txtForgotPassword,txtContact;
    private EditText email;
    private TextView txtMatKhau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AnhXa();
        Click();




    }

    void Click(){
        edtUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUserName.setTextSize(15f);
            }
        });

        edtPassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPassWord.setTextSize(15f);
            }
        });

        flbForMatText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtUserName.getText().toString().trim();
                String pass=edtPassWord.getText().toString().trim();
                if (name.equals("")&& pass.equals("")){
                    edtUserName.setError(getString(R.string.error_Delete));
                    edtPassWord.setError(getString(R.string.error_Delete));
                }
                else {
                    edtUserName.setText("");
                    edtUserName.setHint("Nguyễn Văn Tình");
                    edtUserName.setTextSize(10f);
                    edtPassWord.setText("");
                    edtPassWord.setHint("***********");
                    edtPassWord.setTextSize(10f);

                }
            }
        });

        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(LoginActivity.this);
               dialog.setContentView(R.layout.dialog_forgot_password);

                Button gui=dialog.findViewById(R.id.gui);
                Button huy=dialog.findViewById(R.id.huy);
                email=dialog.findViewById(R.id.maila);
                txtMatKhau=dialog.findViewById(R.id.txtMatKhau);

                gui.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String a="(\\w)+\\@((\\w)+\\.)+(\\w{2,4})";
                        String b=email.getText().toString();

                        if (b.matches(a)){
                           txtMatKhau.setText("Mật khẩu của bạn:NguyenTinh");
                        }else {
                            email.setError("Email không hợp lệ");
                        }
                    }
                });

                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });




               dialog.show();
            }
        });

        txtContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(LoginActivity.this);
                dialog.setContentView(R.layout.dialog_gioithieu);
                dialog.show();
            }
        });
    }

    void AnhXa(){
        edtUserName=findViewById(R.id.edtUserNam);
        edtPassWord=findViewById(R.id.edtPassWord);

        ckbRememberPassword =  findViewById(R.id.ckbRememberPassword);
        flbForMatText =  findViewById(R.id.flbForMatText);
        flbForMatText.setImageResource(R.drawable.ic_delete);

        txtForgotPassword=findViewById(R.id.txtForgotpassword);
        txtContact=findViewById(R.id.txtContact);


    }

    void KiemTra(){
        String name=edtUserName.getText().toString().trim();
        String pass=edtPassWord.getText().toString().trim();

        if (name.equals("")){
            edtUserName.setError(getString(R.string.error_UserName));
            return;
        }

        String[] b={"!","~","@","#","$","%","^","&","*","*","(",")","_","-","=","+","[","]",";",":","\\","|","?","/","<",">",".",",","'"};
        //Toast.makeText(this, ""+b.length, Toast.LENGTH_SHORT).show();
        for (int i=0;i<b.length;i++){
            if (name.indexOf(b[i])>-1){
                edtUserName.setError(getString(R.string.error_Ki_Tu_Dac_Bite));
                return;
            }

        }

        if (pass.equals("")){
            edtPassWord.setError(getString(R.string.error_PassWord));
            return;
        }

        for (int i=0;i<b.length;i++){
            if (pass.indexOf(b[i])>-1){

                edtPassWord.setError(getString(R.string.error_Ki_Tu_Dac_Bite));
                return;
            }

        }

        if (pass.length()<6){

            edtPassWord.setError(getString(R.string.error_PassWord_It_Hon_6Ki_Tu));
            return;
        }

        startActivity(new Intent(this,HomeActivity.class));
        finish();


        }



    public void DangNhap(View view) {

       KiemTra();
    }
}
