package com.example.sindy.controleevaluationm1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sindy.controleevaluationm1.model.Question;
import com.example.sindy.controleevaluationm1.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{

    private ArrayList<Question> questions;

    public QuestionAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitre, txtDate, txtId;
        ImageView profilImg;
        ViewHolder(View itemView) {
            super(itemView);
            txtTitre = itemView.findViewById(R.id.txt_titre);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtId = itemView.findViewById(R.id.txt_id);
            profilImg = itemView.findViewById(R.id.photoUserImg);
        }
    }

    @NonNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_questions, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.txtTitre.setText(question.getTitre());
        holder.txtDate.setText(String.valueOf(question.getDate()));
        holder.txtId.setText(String.valueOf(question.getId()));
        holder.profilImg.setImageResource(question.getProfil());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}