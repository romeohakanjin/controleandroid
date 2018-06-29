package com.example.sindy.controleevaluationm1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sindy.controleevaluationm1.database.AppDatabase;
import com.example.sindy.controleevaluationm1.database.FavoriteQuestionEntity;

public class FragmentFavoriteQuestions extends Fragment implements View.OnClickListener{
    private View view;
    private AppDatabase db;

    public FragmentFavoriteQuestions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db = AppDatabase.getDatabase(container.getContext());

        view = inflater.inflate(R.layout.fragment_favorite_questions, container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.removeFavoriteQuestion);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.removeFavoriteQuestion:
                int id = Integer.valueOf(view.findViewById(R.id.txt_id).toString());
                String titre = view.findViewById(R.id.txt_titre).toString();
                String date = view.findViewById(R.id.txt_date).toString();
                //int profil = Integer.valueOf(view.findViewById(R.id.profilImg));
                Toast.makeText(getContext(), "id : "+id, Toast.LENGTH_SHORT).show();
                db.FavoriteQuestionDao().removeFavoriteQuestionById(id);
                break;
        }
    }
}
