package com.salazarisaiahnoel.pacmanandroid.database;

import androidx.room.Dao;
import androidx.room.Insert;


@Dao
public interface ResultadoDao {

    @Insert
    void insert(Resultado resultado);

}
