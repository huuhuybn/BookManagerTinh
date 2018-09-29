package com.tinh.dev.myapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tinh.dev.myapplication.R;

public class UserHolder extends RecyclerView.ViewHolder {
    public final TextView txtChinh,txtPhu;
    public final ImageView imgView;

    public final ImageView btnDelete;


    public final ImageView btnEdit;



    public UserHolder(View itemView) {
        super(itemView);

        btnEdit = itemView.findViewById(R.id.btnEdit);
        txtChinh=itemView.findViewById(R.id.txtChinh);
        txtPhu=itemView.findViewById(R.id.txtPhu);
        imgView=itemView.findViewById(R.id.imgView);
        btnDelete = itemView.findViewById(R.id.btnDeleteUser);


    }
}
