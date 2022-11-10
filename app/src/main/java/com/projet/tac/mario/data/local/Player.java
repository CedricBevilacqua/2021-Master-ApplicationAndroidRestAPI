package com.projet.tac.mario.data.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Représente un élément joueur de la table Room, aussi utilisé pour représenter un joueur de
 * manière générale
 */
@Entity
public class Player {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private int ressourceIcon;
    private String rarity;
    private String specialSkill;
    private String debutTour;
    private String dateAdded;

    /**
     * Initialise un joueur avec tous ses attributs
     */
    public Player(String name, String rarity, String specialSkill, String debutTour, String dateAdded) {
        setName(name);
        setRarity(rarity);
        setSpecialSkill(specialSkill);
        setDebutTour(debutTour);
        setDateAdded(dateAdded);
    }

    /**
     * Getters/Setters utilisés par Room pour accéder aux données
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRessourceIcon(int ressourceIcon) { this.ressourceIcon = ressourceIcon; }

    public int getRessourceIcon() { return this.ressourceIcon; }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSpecialSkill() {
        return specialSkill;
    }

    public void setSpecialSkill(String specialSkill) {
        this.specialSkill = specialSkill;
    }

    public String getDebutTour() {
        return debutTour;
    }

    public void setDebutTour(String debutTour) {
        this.debutTour = debutTour;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

}