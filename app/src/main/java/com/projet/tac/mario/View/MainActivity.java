package com.projet.tac.mario.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.projet.tac.mario.R;
import com.projet.tac.mario.View.favorite.FragmentFavourite;
import com.projet.tac.mario.View.marioPlayers.FragmentAll;
import com.projet.tac.mario.viewModel.MarioViewModel;

public class MainActivity extends AppCompatActivity {

    private MarioViewModel viewModel;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private FragmentAll fragmentAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        //Affichage des fragments
        viewPager = findViewById(R.id.tab_viewpager);
        tabLayout = findViewById(R.id.tablayout);
        setupViewPagerAndTabs();

        //Création du ViewModel et abonnement
        viewModel = new ViewModelProvider(this).get(MarioViewModel.class);
    }

    private void setupViewPagerAndTabs() {
        //Déclaration des fragments
        fragmentAll = FragmentAll.newInstance();
        final FragmentFavourite fragmentFavourite = FragmentFavourite.newInstance();

        //Création des fragments
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 2;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if(position == 0) {
                    return fragmentAll;
                }
                else if(position == 1) {
                    return fragmentFavourite;
                }
                else {
                    return null;
                }
            }
        });

        //Configuration du texte pour chaque onglet
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                        if(i == 0) {
                            tab.setText("Mario");
                        } else if(i == 1) {
                            tab.setText("Favoris");
                        }
                    }
                }
        );

        tabLayoutMediator.attach();
    }

}