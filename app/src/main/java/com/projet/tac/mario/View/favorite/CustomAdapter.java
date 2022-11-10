package com.projet.tac.mario.View.favorite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projet.tac.mario.R;
import com.projet.tac.mario.View.PlayerInfos;
import com.projet.tac.mario.data.local.Player;
import com.projet.tac.mario.viewModel.MarioViewModel;

import java.util.ArrayList;

/**
 * Adapter pour gérer l'affichage d'un item de l'onglet de tous les personnages
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final ArrayList<Player> localDataSet;
    private final MarioViewModel viewModel;

    /**
     * Contructeur qui crée l'Adapter et l'initialise avec les attributs en paramètre.
     *
     * @param   dataSet ArrayList<Player>   Les données qui rempliront les vues du RecycleView
     * @param   viewModel   MarioViewModel  Le  vue-modèle par lequel on récupèrera toutes les informations à afficher
     */
    public CustomAdapter(ArrayList<Player> dataSet, MarioViewModel viewModel) {
        this.localDataSet = dataSet;
        this.viewModel = viewModel;
    }

    /**
     * Appelé par le RecyclerView pour créer un ViewHolder à l'interieur
     *
     * @return  Le ViewHolder créé et initialisé
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Crée une vue pour une ligne dans la liste et définit son IHM
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_card, parent, false);

        return new MyViewHolder(view, parent.getContext());
    }

    /**
     * Ajoute tout le contenu au ViewHolder et défini ses événements en mettant à jour son contenu à
     * partir du dataset
     *
     * @param holder    MyViewHolder    Elément à remplir et à définir
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Player data = getLocalDataSet(holder.getAdapterPosition());
        holder.setPlayer(data);
        holder.getTextView().setText(data.getName());
        holder.getImageView().setBackgroundResource(data.getRessourceIcon());
        // Evénement de clic pour ajouter aux favoris
        holder.getImageClique().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.removePlayer(data);
                Toast.makeText(view.getContext(), "Supprimé des favoris", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Récupère un élément du dataset
     */
    private Player getLocalDataSet(int position) { return localDataSet.get(position); }

    /**
     * Récupère la taille du dataset
     */
    @Override
    public int getItemCount() { return localDataSet.size(); }


    /**
     * Classe interne qui contrôle la vue d'un item
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private ImageView imageView;
        private ImageView clique;
        private Player player;

        /**
         * Constructeur qui crée un élément dans la liste
         */
        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            itemView.setOnClickListener(new OnClickListener() {
                /**
                 * Ouvre la page d'affichage des détails d'un personnage
                 */
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayerInfos.class);
                    intent.putExtra("playerRessourceIcon", String.valueOf(player.getRessourceIcon()));
                    intent.putExtra("playerName", player.getName());
                    intent.putExtra("playerRarity", player.getRarity());
                    intent.putExtra("playerSpecialSkill", player.getSpecialSkill());
                    intent.putExtra("playerDebutTour", player.getDebutTour());
                    intent.putExtra("playerDateAdded", player.getDateAdded());
                    context.startActivity(intent);
                }
            });

            textView = itemView.findViewById(R.id.textItem);
            clique = itemView.findViewById(R.id.favori);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public ImageView getImageClique(){
            return clique;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }
    }
}
