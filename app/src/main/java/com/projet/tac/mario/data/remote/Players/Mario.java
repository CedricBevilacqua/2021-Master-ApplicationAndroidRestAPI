package com.projet.tac.mario.data.remote.Players;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Mario {

    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("special_skill")
    @Expose
    private String specialSkill;
    @SerializedName("debut_tour")
    @Expose
    private String debutTour;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("level_one_favorite_courses")
    @Expose
    private List<LevelOneFavoriteCourse> levelOneFavoriteCourses = null;
    @SerializedName("level_three_favorite_courses")
    @Expose
    private List<LevelThreeFavoriteCourse> levelThreeFavoriteCourses = null;
    @SerializedName("level_six_favorite_courses")
    @Expose
    private List<LevelSixFavoriteCourse> levelSixFavoriteCourses = null;
    @SerializedName("is_daily_select")
    @Expose
    private Boolean isDailySelect;
    @SerializedName("is_in_pipes")
    @Expose
    private Boolean isInPipes;
    @SerializedName("baby")
    @Expose
    private Boolean baby;
    @SerializedName("crown")
    @Expose
    private Boolean crown;
    @SerializedName("dress")
    @Expose
    private Boolean dress;
    @SerializedName("earrings")
    @Expose
    private Boolean earrings;
    @SerializedName("extended_tongue")
    @Expose
    private Boolean extendedTongue;
    @SerializedName("gloves")
    @Expose
    private Boolean gloves;
    @SerializedName("hat")
    @Expose
    private Boolean hat;
    @SerializedName("helmet")
    @Expose
    private Boolean helmet;
    @SerializedName("horns")
    @Expose
    private Boolean horns;
    @SerializedName("kong")
    @Expose
    private Boolean kong;
    @SerializedName("koopaling")
    @Expose
    private Boolean koopaling;
    @SerializedName("mustache")
    @Expose
    private Boolean mustache;
    @SerializedName("ribbon")
    @Expose
    private Boolean ribbon;
    @SerializedName("shell")
    @Expose
    private Boolean shell;
    @SerializedName("short_sleeves")
    @Expose
    private Boolean shortSleeves;
    @SerializedName("three_hairs")
    @Expose
    private Boolean threeHairs;
    @SerializedName("tie")
    @Expose
    private Boolean tie;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<LevelOneFavoriteCourse> getLevelOneFavoriteCourses() {
        return levelOneFavoriteCourses;
    }

    public void setLevelOneFavoriteCourses(List<LevelOneFavoriteCourse> levelOneFavoriteCourses) {
        this.levelOneFavoriteCourses = levelOneFavoriteCourses;
    }

    public List<LevelThreeFavoriteCourse> getLevelThreeFavoriteCourses() {
        return levelThreeFavoriteCourses;
    }

    public void setLevelThreeFavoriteCourses(List<LevelThreeFavoriteCourse> levelThreeFavoriteCourses) {
        this.levelThreeFavoriteCourses = levelThreeFavoriteCourses;
    }

    public List<LevelSixFavoriteCourse> getLevelSixFavoriteCourses() {
        return levelSixFavoriteCourses;
    }

    public void setLevelSixFavoriteCourses(List<LevelSixFavoriteCourse> levelSixFavoriteCourses) {
        this.levelSixFavoriteCourses = levelSixFavoriteCourses;
    }

    public Boolean getIsDailySelect() {
        return isDailySelect;
    }

    public void setIsDailySelect(Boolean isDailySelect) {
        this.isDailySelect = isDailySelect;
    }

    public Boolean getIsInPipes() {
        return isInPipes;
    }

    public void setIsInPipes(Boolean isInPipes) {
        this.isInPipes = isInPipes;
    }

    public Boolean getBaby() {
        return baby;
    }

    public void setBaby(Boolean baby) {
        this.baby = baby;
    }

    public Boolean getCrown() {
        return crown;
    }

    public void setCrown(Boolean crown) {
        this.crown = crown;
    }

    public Boolean getDress() {
        return dress;
    }

    public void setDress(Boolean dress) {
        this.dress = dress;
    }

    public Boolean getEarrings() {
        return earrings;
    }

    public void setEarrings(Boolean earrings) {
        this.earrings = earrings;
    }

    public Boolean getExtendedTongue() {
        return extendedTongue;
    }

    public void setExtendedTongue(Boolean extendedTongue) {
        this.extendedTongue = extendedTongue;
    }

    public Boolean getGloves() {
        return gloves;
    }

    public void setGloves(Boolean gloves) {
        this.gloves = gloves;
    }

    public Boolean getHat() {
        return hat;
    }

    public void setHat(Boolean hat) {
        this.hat = hat;
    }

    public Boolean getHelmet() {
        return helmet;
    }

    public void setHelmet(Boolean helmet) {
        this.helmet = helmet;
    }

    public Boolean getHorns() {
        return horns;
    }

    public void setHorns(Boolean horns) {
        this.horns = horns;
    }

    public Boolean getKong() {
        return kong;
    }

    public void setKong(Boolean kong) {
        this.kong = kong;
    }

    public Boolean getKoopaling() {
        return koopaling;
    }

    public void setKoopaling(Boolean koopaling) {
        this.koopaling = koopaling;
    }

    public Boolean getMustache() {
        return mustache;
    }

    public void setMustache(Boolean mustache) {
        this.mustache = mustache;
    }

    public Boolean getRibbon() {
        return ribbon;
    }

    public void setRibbon(Boolean ribbon) {
        this.ribbon = ribbon;
    }

    public Boolean getShell() {
        return shell;
    }

    public void setShell(Boolean shell) {
        this.shell = shell;
    }

    public Boolean getShortSleeves() {
        return shortSleeves;
    }

    public void setShortSleeves(Boolean shortSleeves) {
        this.shortSleeves = shortSleeves;
    }

    public Boolean getThreeHairs() {
        return threeHairs;
    }

    public void setThreeHairs(Boolean threeHairs) {
        this.threeHairs = threeHairs;
    }

    public Boolean getTie() {
        return tie;
    }

    public void setTie(Boolean tie) {
        this.tie = tie;
    }

}
