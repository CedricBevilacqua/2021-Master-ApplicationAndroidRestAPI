package com.projet.tac.mario.View.favorite;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projet.tac.mario.R;
import com.projet.tac.mario.data.local.Player;
import com.projet.tac.mario.viewModel.MarioViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Gère l'onglet d'affichage des éléments mis en favoris
 */
public class FragmentFavourite extends Fragment implements View.OnClickListener{

    private View rootView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CustomAdapter customAdapter;
    private Context context;
    private MarioViewModel viewModel;
    private ArrayList<Player> dataSet = new ArrayList<>(Arrays.asList());

    public FragmentFavourite() {}

    /**
     * Retourne une instance de lui même pour l'instancier
     */
    public static FragmentFavourite newInstance() {
        return new FragmentFavourite();
    }

    /**
     * Gère la création de la vue et l'initialise
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_all, container, false);
        setupRecyclerView();
        abonnementViewModel();
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MarioViewModel.class);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    /**
     * Crée et paramètre le RecyclerView
     */
    private void setupRecyclerView() {
        recyclerView = rootView.findViewById(R.id.myRecyclerView);
        recyclerView.setHasFixedSize(true);

        int orientation = getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {
            layoutManager = new GridLayoutManager(context,2);
        } else {
            layoutManager = new LinearLayoutManager(context);
        }
        recyclerView.setLayoutManager(layoutManager);

        customAdapter = new CustomAdapter(dataSet, viewModel);
        recyclerView.setAdapter(customAdapter);
    }

    /**
     * S'abonne au contenu récupéré pour l'afficher au fur et à mesure
     */
    private void abonnementViewModel() {
        Observable<List<Player>> call = viewModel.getAllPersons();

        Observer<List<Player>> observer = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Observer<List<Player>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) { }

                    @Override
                    public void onNext(@NonNull List<Player> personList) {
                        afficherListPlayers(personList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("ERROR", e.getMessage());
                    }

                    @Override
                    public void onComplete() { }
                });
    }

    /**
     * Affiche un personnage dans le RecyclerView
     */
    private void afficherListPlayers(List<Player> personList) {
        dataSet.clear();
        for (Player person : personList) {
            dataSet.add(person);
        }
        customAdapter = new CustomAdapter(dataSet, viewModel);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onClick(View v) { }
}