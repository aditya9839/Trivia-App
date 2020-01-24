package com.example.triviaapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.triviaapp.model.Result;

import java.util.List;

@Dao
public interface ResultDao {

    @Query("SELECT * FROM RESULT ORDER BY ID")
    List<Result> loadAllResults();

    @Insert
    void insertResult(Result result);

}
