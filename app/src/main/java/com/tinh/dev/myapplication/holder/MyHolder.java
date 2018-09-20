package com.tinh.dev.myapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tinh.dev.myapplication.R;

public class MyHolder extends RecyclerView.ViewHolder {
    public TextView txtChinh,txtPhu;
    public ImageView imgView;
    public MyHolder(View itemView) {
        super(itemView);
        txtChinh=itemView.findViewById(R.id.txtChinh);
        txtPhu=itemView.findViewById(R.id.txtPhu);
        imgView=itemView.findViewById(R.id.imgView);


    }
}
