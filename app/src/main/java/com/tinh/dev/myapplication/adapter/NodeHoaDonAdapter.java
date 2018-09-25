package com.tinh.dev.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tinh.dev.myapplication.model.HoaDon;
import com.tinh.dev.myapplication.R;
import com.tinh.dev.myapplication.holder.UserHolder;

import java.util.ArrayList;

public class NodeHoaDonAdapter extends RecyclerView.Adapter<UserHolder> {

    private Context context;
    private ArrayList<HoaDon> arrayList;

    public NodeHoaDonAdapter(Context context, ArrayList<HoaDon> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cardview,parent,false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        HoaDon nguoiDung=arrayList.get(position);
        holder.txtChinh.setText(nguoiDung.getSTT()+"");
        holder.txtPhu.setText(nguoiDung.getNgay());
        holder.imgView.setImageResource(nguoiDung.getAnh());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
