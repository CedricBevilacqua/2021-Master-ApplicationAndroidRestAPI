package com.projet.tac.mario.data;

import android.app.Application;

import com.projet.tac.mario.R;
import com.projet.tac.mario.data.local.MarioDatabase;
import com.projet.tac.mario.data.local.Player;
import com.projet.tac.mario.data.local.PlayerDao;

import com.projet.tac.mario.data.remote.API_Mario;
import com.projet.tac.mario.data.remote.Players.Mario;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;


import io.reactivex.Observable;

/**
 * Centralise la récupération de toutes les ressources issues des ressources locales, de la base de
 * donnée et de l'API
 */
public class Repository {

    private MarioDatabase db;
    private PlayerDao playerDao;

    /**
     * Contructeur qui crée le Repository et l'initialise avec la base de données
     */
    public Repository(Application application) {
        db = MarioDatabase.getDatabase(application);
        playerDao = db.playerDao();
    }

    /**
     * Ajoute un joueur à la base de données
     *
     * @param   player Player   L'élément à ajouter
     */
    public void insert(Player player) {
        MarioDatabase.databaseWriteExecutor.execute(() -> {
            playerDao.insert(player);
        });
    }

    /**
     * Supprime un joueur à la base de données
     *
     * @param   player Player   L'élément à supprimer
     */
    public void delete(Player player) {
        MarioDatabase.databaseWriteExecutor.execute(() -> {
            playerDao.delete(player);
        });
    }

    /**
     * Ajoute un joueur à la base de données
     *
     * @return   Un observable pour récupérer au fur et à mesure les éléments en ligne
     */
    public Observable<List<Mario>> getPlayersFromRemote() {
        Observable<List<Mario>> playersObservable = API_Mario.getInstance().getMyApi().getPlayers();
        return playersObservable;
    }

    public Observable<List<Player>> getAllPersons() {
        return db.playerDao().getAllPersons();
    }

    /**
     * Vérifie si un joueur existe dans la base de données
     *
     * @return   Un observable pour récupérer la réponse de Room
     */
    public Observable<Integer> playerExistInFavori(String name){
        return playerDao.playerExists(name);
    }

    /**
     * Récupère une pointeur correspondant à une ressource d'image aléatoire parmi 20
     *
     * @return   Pointeur vers la ressource d'image
     */
    public int getImage() {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(20);
        if(nombreAleatoire == 0) {
            return R.drawable.baby_daisy;
        } else if(nombreAleatoire == 1) {
            return R.drawable.baby_luigi;
        } else if(nombreAleatoire == 2) {
            return R.drawable.baby_mario;
        } else if(nombreAleatoire == 3) {
            return R.drawable.baby_peach;
        } else if(nombreAleatoire == 4) {
            return R.drawable.baby_rosalina;
        } else if(nombreAleatoire == 5) {
            return R.drawable.daisy;
        } else if(nombreAleatoire == 6) {
            return R.drawable.dry_bones;
        } else if(nombreAleatoire == 7) {
            return R.drawable.iggy;
        } else if(nombreAleatoire == 8) {
            return R.drawable.koopa_troopa;
        } else if(nombreAleatoire == 9) {
            return R.drawable.larry;
        } else if(nombreAleatoire == 10) {
            return R.drawable.lemmy;
        } else if(nombreAleatoire == 11) {
            return R.drawable.ludwig;
        } else if(nombreAleatoire == 12) {
            return R.drawable.mario;
        } else if(nombreAleatoire == 13) {
            return R.drawable.morton;
        } else if(nombreAleatoire == 14) {
            return R.drawable.peach;
        } else if(nombreAleatoire == 15) {
            return R.drawable.roy;
        } else if(nombreAleatoire == 16) {
            return R.drawable.shy_guy;
        } else if(nombreAleatoire == 17) {
            return R.drawable.toad;
        } else if(nombreAleatoire == 18) {
            return R.drawable.unknow;
        } else if(nombreAleatoire == 19) {
            return R.drawable.wendy;
        } else if(nombreAleatoire == 20) {
            return R.drawable.yoshi;
        }
        return R.drawable.unknow;
    }
}