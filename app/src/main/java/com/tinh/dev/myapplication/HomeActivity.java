package com.tinh.dev.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;


    private LinearLayout layoutND;
    private LinearLayout layoutQLS;
    private LinearLayout layoutSBC;
    private LinearLayout layoutTL;
    private LinearLayout layoutHD;
    private LinearLayout layoutTK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AnhXa();
        onClick();



    }


    void AnhXa(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");
        drawerLayout =  findViewById(R.id.drawerLayout);
        navigationView =  findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);







        layoutND = (LinearLayout) findViewById(R.id.layout_ND);
        layoutQLS = (LinearLayout) findViewById(R.id.layout_QLS);
        layoutSBC = (LinearLayout) findViewById(R.id.layout_SBC);
        layoutTL = (LinearLayout) findViewById(R.id.layout_TL);
        layoutHD = (LinearLayout) findViewById(R.id.layout_HD);
        layoutTK = (LinearLayout) findViewById(R.id.layout_TK);














    }

    void onClick(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });

        layoutND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,NguoiDung_Activity.class));
            }
        });

        layoutQLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,QLS_Activity.class));
            }
        });

        layoutSBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,SBC_Activity.class));
            }
        });

        layoutTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,QLLS_Activity.class));
            }
        });

        layoutTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ThongKe_Activity.class));
            }
        });

        layoutHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,HoaDon_Activity.class));
            }
        });









//        layoutDoiMatKhau.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this,ChangePasswordActivity.class));
//            }
//        });
//        layoutDangXuat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
//                finish();
//            }
//        });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.ic_QLLS:
                startActivity(new Intent(HomeActivity.this,QLLS_Activity.class));
                break;

            case R.id.ic_QLS:
                startActivity(new Intent(HomeActivity.this,QLS_Activity.class));
                break;

            case R.id.ic_QLTC:
                startActivity(new Intent(HomeActivity.this,ThongKe_Activity.class));
                break;

            case R.id.ic_GT:
                //startActivity(new Intent(HomeActivity.this,QLS_Activity.class));
                break;

            case R.id.ic_DMK:
                startActivity(new Intent(HomeActivity.this,ChangePasswordActivity.class));
                break;

            case R.id.ic_DX:
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                finish();
                break;

            case R.id.ic_T:
                Exit();
                break;

        }
        drawerLayout.closeDrawer(Gravity.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {




       return true;
    }

    private void Exit() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thoát");
        builder.setMessage("Bạn có muốn thoát không?");
        builder.setIcon(R.drawable.canhbao);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();



    }
}
