package com.example.sindy.controleevaluationm1.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.sindy.controleevaluationm1.model.FavoriteQuestion;

@Database(entities = {FavoriteQuestionEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase db;

    public static AppDatabase getDatabase(Context context){
        if(db == null){
            db = Room.databaseBuilder(context, AppDatabase.class, "my_db").allowMainThreadQueries().build();
        }
        return db;
    }

    public abstract FavoriteQuestionDao FavoriteQuestionDao();
}
