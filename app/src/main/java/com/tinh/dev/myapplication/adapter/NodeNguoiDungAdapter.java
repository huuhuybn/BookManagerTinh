package com.tinh.dev.myapplication.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.tinh.dev.myapplication.model.User;
import com.tinh.dev.myapplication.R;
import com.tinh.dev.myapplication.holder.UserHolder;
import com.tinh.dev.myapplication.sqlitedao.UserDAO;

import java.util.List;

public class NodeNguoiDungAdapter extends RecyclerView.Adapter<UserHolder> {
    private Context context;
    private List<User> userList;
    private UserDAO userDAO;


    public NodeNguoiDungAdapter(Context context, List<User> userList, UserDAO userDAO) {
        this.context = context;
        this.userList = userList;
        this.userDAO = userDAO;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cardview,parent,false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, final int position) {
            User nguoiDung= userList.get(position);
            holder.txtChinh.setText(nguoiDung.getTenNguoiDung());
            holder.txtPhu.setText(nguoiDung.getSDT()+"");
            holder.imgView.setImageResource(nguoiDung.getAnhNguoiDung());

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userDAO.deleteUser(userList.get(position).getUsername());
                    userList.remove(position);
                    notifyDataSetChanged();
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final Dialog dialog = new Dialog(context);
                    dialog.setTitle(userList.get(position).getTenNguoiDung());

                    dialog.setContentView(R.layout.dialog_edit_user);

                     EditText edtPassWord;
                     EditText edtConfirmPassword;
                     final EditText edtName;
                     final EditText edtPhone;

                    edtPassWord = dialog.findViewById(R.id.edtPassWord);
                    edtConfirmPassword = dialog.findViewById(R.id.edtConfirmPassword);
                    edtName = dialog.findViewById(R.id.edtName);
                    edtPhone = dialog.findViewById(R.id.edtPhone);

                    edtName.setText(userList.get(position).getTenNguoiDung());
                    edtPhone.setText(userList.get(position).getSDT());


                    dialog.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            User user = new User();
                            user.setUsername(userList.get(position).getUsername());
                            user.setTenNguoiDung(edtName.getText().toString().trim());
                            user.setSDT(edtPhone.getText().toString().trim());

                            userDAO.updateUser(user);

                            // cap nhat thay doi len giao dien
                            userList.get(position).setTenNguoiDung(edtName.getText().toString().trim());
                            userList.get(position).setSDT(edtPhone.getText().toString().trim());
                            notifyDataSetChanged();

                            Toast.makeText(context,context.getString(R.string.notify_save_successful),Toast.LENGTH_SHORT).show();
                            dialog.dismiss();


                        }
                    });
                   dialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           dialog.dismiss();
                       }
                   });

                   dialog.show();


                }
            });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
