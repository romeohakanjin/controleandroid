package com.example.sindy.controleevaluationm1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sindy.controleevaluationm1.model.FavoriteQuestion;
import com.example.sindy.controleevaluationm1.R;

import java.util.ArrayList;

public class FavoriteQuestionAdapter extends RecyclerView.Adapter<FavoriteQuestionAdapter.ViewHolder>{

    private ArrayList<FavoriteQuestion> favoriteQuestions;

    public FavoriteQuestionAdapter(ArrayList<FavoriteQuestion> favoriteQuestions) {
        this.favoriteQuestions = favoriteQuestions;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitre, txtDate;
        ImageView profilImg;
        ViewHolder(View itemView) {
            super(itemView);
            txtTitre = itemView.findViewById(R.id.txt_titre);
            txtDate = itemView.findViewById(R.id.txt_date);
            profilImg = itemView.findViewById(R.id.photoUserImg);
        }
    }

    @NonNull
    @Override
    public FavoriteQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_favorite_questions, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteQuestionAdapter.ViewHolder holder, int position) {
        FavoriteQuestion favoriteQuestion = favoriteQuestions.get(position);
        holder.txtTitre.setText(favoriteQuestion.getTitre());
        holder.txtDate.setText(String.valueOf(favoriteQuestion.getDate()));
        //holder.profilImg.setImageResource(favoriteQuestion.getProfil());
    }

    @Override
    public int getItemCount() {
        return favoriteQuestions.size();
    }
}