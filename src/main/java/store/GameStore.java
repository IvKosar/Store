package store;

import game.ComputerGame;
import game.Genre;
import game.Platform;

import java.util.ArrayList;

public class GameStore {
    private ArrayList<ComputerGame> games;

    public GameStore(){
        games = new ArrayList<>();
    }

    public ArrayList<ComputerGame> getGames() { return games; }

    public void add(ComputerGame computerGame){
        this.games.add(computerGame);
    }

    public ComputerGame search(ComputerGame searchGame){
        for (ComputerGame game : this.games){
            if (game.getParams().getAgePrestriction() > searchGame.getParams().getAgePrestriction())
                continue;
            if (!game.getParams().getDescription().toLowerCase().equals(searchGame.getParams().getDescription().toLowerCase()))
                continue;
            if (!genresSatisfied(game, searchGame))
                continue;
            if (!platformsSatisfied(game, searchGame))
                continue;
            return game;
        }
        return null;
    }

    public boolean genresSatisfied(ComputerGame game, ComputerGame searchGame){
        ArrayList<Genre> gameGenres = game.getParams().getGenres();
        ArrayList<Genre> searchGameGenres = searchGame.getParams().getGenres();

        if (searchGameGenres.isEmpty() && gameGenres.isEmpty())
            return true;
        else if (searchGameGenres.isEmpty() || gameGenres.isEmpty())
            return false;

        for (Genre genre : searchGameGenres)
            if (!gameGenres.contains(genre))
                return false;
        return true;
    }

    public boolean platformsSatisfied(ComputerGame game, ComputerGame searchGame){
        ArrayList<Platform> gamePlatforms = game.getParams().getPlatforms();
        ArrayList<Platform> searchGamePlatforms = searchGame.getParams().getPlatforms();

        if (gamePlatforms.isEmpty() && searchGamePlatforms.isEmpty())
            return true;
        else if (gamePlatforms.isEmpty() || searchGamePlatforms.isEmpty())
            return false;

        for (Platform platform : searchGamePlatforms)
            if (!gamePlatforms.contains(platform))
                return false;
        return true;}
}
