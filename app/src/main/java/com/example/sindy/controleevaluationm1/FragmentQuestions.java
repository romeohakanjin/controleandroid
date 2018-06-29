package com.example.sindy.controleevaluationm1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sindy.controleevaluationm1.database.AppDatabase;
import com.example.sindy.controleevaluationm1.database.FavoriteQuestionEntity;

public class FragmentQuestions extends Fragment implements View.OnClickListener{
    private View view;
    private AppDatabase db;

    public FragmentQuestions() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        db = AppDatabase.getDatabase(container.getContext());

        view = inflater.inflate(R.layout.fragment_questions, container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.addFavoriteQuestion);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addFavoriteQuestion:
                TextView idTextField = view.findViewById(R.id.txt_id);
                TextView titreTextField = view.findViewById(R.id.txt_titre);
                TextView dateTextField = view.findViewById(R.id.txt_date);

                int id = Integer.valueOf(idTextField.getText().toString());
                String titre = titreTextField.getText().toString();
                String date = dateTextField.getText().toString();
                //int profil = Integer.valueOf(view.findViewById(R.id.profilImg));

                db.FavoriteQuestionDao().insertFavoriteQuestion(new FavoriteQuestionEntity(id, titre, date, 4));
                break;
        }
    }
}
