package com.projet.tac.mario.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface PlayerDao {

    /**
     * Insert un joueur dans la BDD
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Player person);

    /**
     * Supprime un joueur de la BDD
     */
    @Delete()
    void delete(Player person);

    /**
     * Récupère les joueurs dans la BDD
     */
    @Query("SELECT * FROM Player")
    Observable<List<Player>> getAllPersons();

    /**
     * Vérifie si un joueur existe dans la BDD
     */
    @Query("SELECT count(*) FROM Player WHERE name=:name")
    Observable<Integer> playerExists(String name);
}