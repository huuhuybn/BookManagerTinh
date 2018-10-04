package com.tinh.dev.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tinh.dev.myapplication.database.DatabaseHelper;
import com.tinh.dev.myapplication.holder.HolderBill;
import com.tinh.dev.myapplication.model.Bill;
import com.tinh.dev.myapplication.R;
import com.tinh.dev.myapplication.holder.UserHolder;
import com.tinh.dev.myapplication.sqlitedao.BillDAO;

import java.util.ArrayList;
import java.util.Date;

public class NodeHoaDonAdapter extends RecyclerView.Adapter<HolderBill> {

    private Context context;
    private ArrayList<Bill> arrayList;

    public NodeHoaDonAdapter(Context context, ArrayList<Bill> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HolderBill onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_bill, parent, false);
        return new HolderBill(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderBill holder, final int position) {
        final Bill bill = arrayList.get(position);

        String date = new Date(bill.date).toString();

        holder.tvInfo.setText(bill.id + "\n" + date);

        // su kien XOA Bill
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BillDAO billDAO = new BillDAO(new DatabaseHelper(context));
                billDAO.delBill(bill.id);
                arrayList.remove(position);
                // cap nhat lai giao dien
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
