package com.salazarisaiahnoel.pacmanandroid.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Resultado.class}, version = 1, exportSchema = false)
public abstract class PacmanBD extends RoomDatabase {
    public abstract ResultadoDao gameResultadoDao();
    private static PacmanBD INSTANCE;

    public static PacmanBD getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (PacmanBD.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PacmanBD.class, "pacman-database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
