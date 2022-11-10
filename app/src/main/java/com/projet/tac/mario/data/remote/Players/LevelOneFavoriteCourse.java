package com.projet.tac.mario.data.remote.Players;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LevelOneFavoriteCourse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("debut_tour")
    @Expose
    private String debutTour;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("debut_game")
    @Expose
    private String debutGame;
    @SerializedName("is_reverse")
    @Expose
    private Boolean isReverse;
    @SerializedName("is_trick")
    @Expose
    private Boolean isTrick;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("debut_system")
    @Expose
    private String debutSystem;
    @SerializedName("is_ranked_week_1")
    @Expose
    private Boolean isRankedWeek1;
    @SerializedName("is_ranked_week_2")
    @Expose
    private Boolean isRankedWeek2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDebutGame() {
        return debutGame;
    }

    public void setDebutGame(String debutGame) {
        this.debutGame = debutGame;
    }

    public Boolean getIsReverse() {
        return isReverse;
    }

    public void setIsReverse(Boolean isReverse) {
        this.isReverse = isReverse;
    }

    public Boolean getIsTrick() {
        return isTrick;
    }

    public void setIsTrick(Boolean isTrick) {
        this.isTrick = isTrick;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDebutSystem() {
        return debutSystem;
    }

    public void setDebutSystem(String debutSystem) {
        this.debutSystem = debutSystem;
    }

    public Boolean getIsRankedWeek1() {
        return isRankedWeek1;
    }

    public void setIsRankedWeek1(Boolean isRankedWeek1) {
        this.isRankedWeek1 = isRankedWeek1;
    }

    public Boolean getIsRankedWeek2() {
        return isRankedWeek2;
    }

    public void setIsRankedWeek2(Boolean isRankedWeek2) {
        this.isRankedWeek2 = isRankedWeek2;
    }

}
