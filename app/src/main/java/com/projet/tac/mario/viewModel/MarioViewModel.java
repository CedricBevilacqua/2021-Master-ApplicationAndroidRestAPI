package com.projet.tac.mario.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.projet.tac.mario.data.Repository;
import com.projet.tac.mario.data.local.Player;
import com.projet.tac.mario.data.remote.Players.Mario;

import java.util.List;

import io.reactivex.Observable;

public class MarioViewModel extends AndroidViewModel {

    private Repository repository;


    // Constructeur avec un contexte en paramètre.
    // On utilise ce contexte pour créer le repository
    public MarioViewModel(@NonNull Application application) {
        super(application);

        createRepository(application);
        getAllPersons();
    }

    private void createRepository(Application application) {
        repository = new Repository(application);
    }


    // methode qui demande la liste de toutes les Person au repository, puis qui transforme le
    // résultat (flux Rx Single) en LiveData (données exposées en lecture seule aux vues)
    // On utilise un Observable pour prendre en compte immédiatement les màj de la BDD,
    // cf. https://medium.com/androiddevelopers/room-rxjava-acb0cd4f3757 pour explications
    public Observable<List<Player>> getAllPersons() {
        Observable<List<Player>> persons = repository.getAllPersons();
        return persons;
    }

    // on requête la BDD (par l'intermédiaire du repository) pour ajouter une Person
    public void addPlayer(Player person) {
        repository.insert(person);
    }

    public void removePlayer(Player person) {
        repository.delete(person);
    }

    public Observable<Integer> checkPlayerFavori(String name){ return repository.playerExistInFavori(name); }

    public Observable<List<Mario>> getPlayersFromRemote() {
        Observable<List<Mario>> call = repository.getPlayersFromRemote();
        return call;
    }

    public int setImage() {
        return repository.getImage();
    }
}