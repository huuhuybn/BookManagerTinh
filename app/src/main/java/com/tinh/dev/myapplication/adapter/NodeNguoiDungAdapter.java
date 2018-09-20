package com.tinh.dev.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tinh.dev.myapplication.model.User;
import com.tinh.dev.myapplication.R;
import com.tinh.dev.myapplication.holder.MyHolder;

import java.util.ArrayList;

public class NodeNguoiDungAdapter extends RecyclerView.Adapter<MyHolder> {
    private Context context;
    private ArrayList<User> arrayList;

    public NodeNguoiDungAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cardview,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            User nguoiDung=arrayList.get(position);
            holder.txtChinh.setText(nguoiDung.getTenNguoiDung());
            holder.txtPhu.setText(nguoiDung.getSDT()+"");
            holder.imgView.setImageResource(nguoiDung.getAnhNguoiDung());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
