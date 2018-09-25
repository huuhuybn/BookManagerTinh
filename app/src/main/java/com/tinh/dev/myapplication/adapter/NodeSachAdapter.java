package com.tinh.dev.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tinh.dev.myapplication.model.Book;
import com.tinh.dev.myapplication.R;
import com.tinh.dev.myapplication.holder.UserHolder;

import java.util.ArrayList;

public class NodeSachAdapter extends RecyclerView.Adapter<UserHolder> {

    private Context context;
    private ArrayList<Book> arrayList;

        public NodeSachAdapter(Context context, ArrayList<Book> arrayList) {
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
        Book nguoiDung=arrayList.get(position);
        holder.txtChinh.setText(nguoiDung.getTenSach());
        holder.txtPhu.setText(nguoiDung.getSoLuong()+"");
        holder.imgView.setImageResource(nguoiDung.getAnh());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
