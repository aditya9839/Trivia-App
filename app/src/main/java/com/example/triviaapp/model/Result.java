package com.example.triviaapp.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "result")
public class Result {
    @PrimaryKey(autoGenerate = true)
    private
    int id;
    private String name;
    private String bestCricketer;

    public String getNationalColors() {
        return nationalColors;
    }

    public void setNationalColors(String nationalColors) {
        this.nationalColors = nationalColors;
    }

    private String nationalColors;

    @Ignore
    public Result(String name, String bestCricketer,String nationalColors) {
        this.name = name;
        this.bestCricketer = bestCricketer;
        this.nationalColors = nationalColors;

    }

    public Result(int id, String name, String bestCricketer,String nationalColors) {
        this.id = id;
        this.name = name;
        this.bestCricketer = bestCricketer;
        this.nationalColors = nationalColors;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBestCricketer() {
        return bestCricketer;
    }

    public void setBestCricketer(String bestCricketer) {
        this.bestCricketer = bestCricketer;
    }
}
