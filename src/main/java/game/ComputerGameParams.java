package game;

import java.util.ArrayList;

public class ComputerGameParams {
    private String name;
    private ArrayList<Genre> genres;
    private ArrayList<Platform> platforms;
    private String description;
    private int agePrestriction;

    public ComputerGameParams(String name, ArrayList<Genre> genres, ArrayList<Platform> platforms, String descriptionFileName, int agePrestriction) {
        this.name = name;
        this.genres = genres;
        this.platforms = platforms;
        this.description = descriptionFileName;
        this.agePrestriction = agePrestriction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void addPlatform(Platform platform){this.platforms.add(platform);};

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAgePrestriction(int agePrestriction) {
        this.agePrestriction = agePrestriction;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public String getDescription() { return description; }

    public int getAgePrestriction() {
        return agePrestriction;
    }
}
