package com.projet.tac.mario.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Instancie l'API Mario utilisée
 *
 * @return   Un observable pour récupérer au fur et à mesure les éléments en ligne
 */
public class API_Mario {
    private static String BASE_URL ="https://mario-kart-tour-api.herokuapp.com/api/";
    private static Retrofit retrofit;
    private static API_Mario instance = null;
    private API_Interface myAPI;

    /**
     * Constructeur qui se connecte à Retrofit
     */
    public API_Mario() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            myAPI = retrofit.create(API_Interface.class);
        }
    }

    public static API_Mario getInstance() {
        if (instance == null) {
            instance = new API_Mario();
        }
        return instance;
    }

    public API_Interface getMyApi() {
        return myAPI;
    }

}
