package com.example.sindy.controleevaluationm1.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.sindy.controleevaluationm1.model.FavoriteQuestion;
import com.example.sindy.controleevaluationm1.model.User;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FavoriteQuestionDao {
    @Query("SELECT * FROM FavoriteQuestionEntity")
    List<FavoriteQuestionEntity> getFavoriteQuestions();

    @Query("SELECT * FROM FavoriteQuestionEntity WHERE id=:id")
    List<FavoriteQuestionEntity> getFavoriteQuestionById(long id);

    @Query("DELETE FROM FavoriteQuestionEntity WHERE id=:id")
    void removeFavoriteQuestionById(long id);


    @Insert
    void insertFavoriteQuestion(FavoriteQuestionEntity favoriteQuestion);

    @Delete
    void deleteFavoriteQuestion(FavoriteQuestionEntity favoriteQuestion);
}