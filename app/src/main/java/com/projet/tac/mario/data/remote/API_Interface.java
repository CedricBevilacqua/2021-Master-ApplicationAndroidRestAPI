package com.projet.tac.mario.data.remote;


import com.projet.tac.mario.data.remote.Players.Mario;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API_Interface {

    /**
     * Requête de récupération des joueurs sur l'API
     */
    @GET("v1/drivers/super")
    Observable<List<Mario>> getPlayers();

}
