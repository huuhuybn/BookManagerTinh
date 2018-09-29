package com.tinh.dev.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tinh.dev.myapplication.model.TypeBook;
import com.tinh.dev.myapplication.R;
import com.tinh.dev.myapplication.holder.UserHolder;
import com.tinh.dev.myapplication.sqlitedao.TypeBookDAO;

import java.util.ArrayList;
import java.util.List;

public class AdapterTypeBook extends RecyclerView.Adapter<UserHolder> {

    private Context context;
    private List<TypeBook> arrayList;
    private TypeBookDAO typeBookDAO;

    public AdapterTypeBook(Context context, List<TypeBook> arrayList, TypeBookDAO typeBookDAO) {
        this.context = context;
        this.arrayList = arrayList;
        this.typeBookDAO = typeBookDAO;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, final int position) {
        final TypeBook typeBook = arrayList.get(position);
        holder.txtChinh.setText(typeBook.id);
        holder.txtPhu.setText(typeBook.name);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // delete typebook trong DB
                typeBookDAO.deleteTypeBook(typeBook.id);

                // xoa typebook trong arraylist
                arrayList.remove(position);

                // f5 adapter
                notifyDataSetChanged();

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
