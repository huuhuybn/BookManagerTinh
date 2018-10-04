package com.tinh.dev.myapplication.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tinh.dev.myapplication.R;

public class HolderBill extends RecyclerView.ViewHolder {


    public TextView tvInfo;
    public Button btnDel;

    public HolderBill(View itemView) {
        super(itemView);

        tvInfo = itemView.findViewById(R.id.tvInfo);
        btnDel = itemView.findViewById(R.id.btnDel);

    }
}
