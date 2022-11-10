package com.projet.tac.mario.data.local;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Player.class}, version = 2, exportSchema = false)
public abstract class MarioDatabase extends RoomDatabase {

    public abstract PlayerDao playerDao();
    private static volatile MarioDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    /**
     * Initialise au besoin la base de données, s'y connecte et renvoi son instance
     *
     * @return   Base de données renvoyée
     */
    public static MarioDatabase getDatabase(@NonNull final Context context) {
        //context.deleteDatabase("MarioDatabase"); //DEBUG : Supprime toute la BDD au démarrage
        if (INSTANCE == null) {
            synchronized (MarioDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MarioDatabase.class, "MarioDatabase").build();
                }
            }
        }
        return INSTANCE;
    }
}
