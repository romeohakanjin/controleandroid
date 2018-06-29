package com.example.sindy.controleevaluationm1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sindy.controleevaluationm1.R;
import com.example.sindy.controleevaluationm1.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPoints;
        ImageView profilImg;
        ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPoints = itemView.findViewById(R.id.txt_point);
            profilImg = itemView.findViewById(R.id.profilImg);
        }
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_users, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.txtName.setText(user.getName());
        holder.txtPoints.setText(String.valueOf(user.getPoints()));
        holder.profilImg.setImageResource(user.getProfil());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}