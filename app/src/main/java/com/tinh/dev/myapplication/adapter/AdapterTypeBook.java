package com.tinh.dev.myapplication.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tinh.dev.myapplication.QLLS_Activity;
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
                long result = typeBookDAO.deleteTypeBook(typeBook.id);

                if (result < 0) {

                    Toast.makeText(context,"Xoa ko thanh cong!!!",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(context,"Xoa thanh cong!!!",Toast.LENGTH_SHORT).show();
                    // xoa typebook trong arraylist
                    arrayList.remove(position);

                    // f5 adapter
                    notifyDataSetChanged();

                }



            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_add_type_book);

                final EditText edtID;
                final EditText edtName;
                final EditText edtDes;
                final EditText edtPos;
                Button btnAddTypeBook;
                Button btnCancel;

                edtID = dialog.findViewById(R.id.edtID);
                edtID.setVisibility(View.GONE);
                edtName = dialog.findViewById(R.id.edtName);
                edtDes = dialog.findViewById(R.id.edtDes);
                edtPos = dialog.findViewById(R.id.edtPos);
                btnAddTypeBook = dialog.findViewById(R.id.btnAddTypeBook);
                btnCancel = dialog.findViewById(R.id.btnCancel);
                btnAddTypeBook.setText("UPDATE");


                edtName.setText(typeBook.name);
                edtDes.setText(typeBook.des);
                edtPos.setText(typeBook.pos);

                btnAddTypeBook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id = typeBook.id;
                        String name = edtName.getText().toString().trim();
                        String des = edtDes.getText().toString().trim();
                        String pos = edtPos.getText().toString().trim();
                        TypeBook typeBook = new TypeBook(id, name, des, pos);

                        long result = typeBookDAO.updateTypeBook(typeBook);
                        if (result < 0) {
                            Toast.makeText(context, "Cap nhat khong thanh cong. Co loi xay ra !!!", Toast.LENGTH_SHORT).show();
                        } else {

                            arrayList.get(position).name = name;

                            arrayList.get(position).des = des;

                            arrayList.get(position).pos = pos;

                            // f5 recyclerview

                            notifyDataSetChanged();

                            Toast.makeText(context, "Cap nhat loai sach thanh cong!!!", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
