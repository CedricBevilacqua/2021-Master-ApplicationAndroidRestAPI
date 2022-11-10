package com.projet.tac.mario.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.projet.tac.mario.R;
import com.projet.tac.mario.viewModel.MarioViewModel;

public class PlayerInfos extends AppCompatActivity {

    private ImageView avatar;
    private TextView name;
    private TextView rarity;
    private TextView specialSkill;
    private TextView debutTour;
    private TextView dateAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_infos);

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        avatar = findViewById(R.id.IMG_Avatar);
        name = findViewById(R.id.LBL_Name);
        rarity = findViewById(R.id.LBL_RarityValue);
        specialSkill = findViewById(R.id.LBL_SpecialSkillValue);
        debutTour = findViewById(R.id.LBL_CircuitValue);
        dateAdded = findViewById(R.id.LBL_DateAddedValue);

        Intent intent = getIntent();
        String ressourceIcon = intent.getStringExtra("playerRessourceIcon");
        String playerName = intent.getStringExtra("playerName");
        String playerRarity = intent.getStringExtra("playerRarity");
        String playerSpecialSkill = intent.getStringExtra("playerSpecialSkill");
        String playerDebutTour = intent.getStringExtra("playerDebutTour");
        String playerDateAdded = intent.getStringExtra("playerDateAdded");

        avatar.setBackgroundResource(Integer.parseInt(ressourceIcon));
        name.setText(playerName);
        rarity.setText(playerRarity);
        specialSkill.setText(playerSpecialSkill);
        debutTour.setText(playerDebutTour);
        dateAdded.setText(playerDateAdded);
    }
}
