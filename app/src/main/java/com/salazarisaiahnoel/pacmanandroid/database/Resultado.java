package com.salazarisaiahnoel.pacmanandroid.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabla_resultado")
public class Resultado {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "tiempo")
    public int time;

    @ColumnInfo(name = "resultado")
    public String result;

    // Constructor, getters y setters

    public Resultado(int id, int time, String result) {
        this.id = id;
        this.time = time;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
