package store;

import game.*;
import store.GameStore;

import org.junit.Before;
import org.junit.Test;
import store.GameStore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;

public class GameStoreTest {
    private ArrayList<ComputerGame> games;
    private GameStore gameStore;

    @Before
    public void InitializeStore(){ gameStore = new GameStore(); }

    @Test
    public void testGetGames(){
        games = new ArrayList<>();
        assertEquals(games, gameStore.getGames());
    }

    @Test
    public void testAddGame(){
        ComputerGameParams params = new ComputerGameParams("a", new ArrayList<Genre>(), new ArrayList<Platform>(), "desc", 14);
        ComputerGame game = new ComputerGame(23.5f, params);
        games = new ArrayList<>();
        games.add(game);
        gameStore.add(game);
        assertEquals(games, gameStore.getGames());
    }

    @Test
    public void testSearchNotFoundNoGameInStore(){
        ComputerGameParams params = new ComputerGameParams("a", new ArrayList<Genre>(), new ArrayList<Platform>(), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, params);
        assertNull(gameStore.search(searchGame));
    }

    @Test
    public void testSearchNotFoundBadAgePrest(){
        ComputerGameParams storeGameParams = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 16);
        ComputerGame game = new ComputerGame(25.5f, storeGameParams);
        ComputerGameParams searchParams = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, searchParams);

        games = new ArrayList<>();
        games.add(game);
        assertNull(gameStore.search(searchGame));
    }

    @Test
    public void testSearchNotFoundBadDesc(){
        ComputerGameParams storeGameParams = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "wrong desc", 14);
        ComputerGame game = new ComputerGame(25.5f, storeGameParams);
        ComputerGameParams searchParams = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, searchParams);

        games = new ArrayList<>();
        games.add(game);
        assertNull(gameStore.search(searchGame));
    }

    @Test
    public void testSearchNotFoundBadGenres(){
        ComputerGameParams storeGameParams = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.SHOOTER)), new ArrayList<Platform>(), "desc", 14);
        ComputerGame game = new ComputerGame(25.5f, storeGameParams);
        ComputerGameParams searchParams = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, searchParams);

        games = new ArrayList<>();
        games.add(game);
        assertNull(gameStore.search(searchGame));
    }

    @Test
    public void testSearchNotFoundBadPlatforms(){
        ComputerGameParams storeGameParams = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(Arrays.asList(Platform.WINDOWS_7)), "desc", 14);
        ComputerGame game = new ComputerGame(25.5f, storeGameParams);
        ComputerGameParams searchParams = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(Arrays.asList(Platform.UBUNTU)), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, searchParams);

        games = new ArrayList<>();
        games.add(game);
        assertNull(gameStore.search(searchGame));
    }

    @Test
    public void testSearchFound(){
        ComputerGameParams params = new ComputerGameParams("a", new ArrayList<Genre>(), new ArrayList<Platform>(), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, params);
        gameStore.add(searchGame);
        assertEquals(searchGame, gameStore.search(searchGame));
    }

    @Test
    public void testGenresSatisfied(){
        ComputerGameParams params1 = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 14);
        ComputerGame game1 = new ComputerGame(23.5f, params1);
        ComputerGameParams params2 = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 16);
        ComputerGame game2 = new ComputerGame(25.5f, params2);
        assertTrue(gameStore.genresSatisfied(game1, game2));
    }

    @Test
    public void testGenresNotSatisfiedBothGamesHaveGenres(){
        ComputerGameParams params1 = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.SHOOTER)), new ArrayList<Platform>(), "desc", 14);
        ComputerGame game1 = new ComputerGame(23.5f, params1);
        ComputerGameParams params2 = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 16);
        ComputerGame game2 = new ComputerGame(25.5f, params2);
        assertFalse(gameStore.genresSatisfied(game1, game2));
    }

    public void testGenresNotSatisfiedOneGameHasGenreAndOneNot(){
        ComputerGameParams params1 = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.SHOOTER)), new ArrayList<Platform>(), "desc", 14);
        ComputerGame game1 = new ComputerGame(23.5f, params1);
        ComputerGameParams params2 = new ComputerGameParams("b", new ArrayList<Genre>(), new ArrayList<Platform>(), "desc", 16);
        ComputerGame game2 = new ComputerGame(25.5f, params2);
        assertFalse(gameStore.genresSatisfied(game1, game2));
    }

    @Test
    public void testPlatformsSatisfied(){
        ComputerGameParams params1 = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(Arrays.asList(Platform.WINDOWS_7)), "desc", 14);
        ComputerGame game1 = new ComputerGame(23.5f, params1);
        ComputerGameParams params2 = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(Arrays.asList(Platform.WINDOWS_7)), "desc", 16);
        ComputerGame game2 = new ComputerGame(25.5f, params2);
        assertTrue(gameStore.platformsSatisfied(game1, game2));
    }

    @Test
    public void testPlatformsNotSatisfiedOneGameHasPlatformsAndOneNot(){
        ComputerGameParams params1 = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.SHOOTER)), new ArrayList<Platform>(Arrays.asList(Platform.WINDOWS_7)), "desc", 14);
        ComputerGame game1 = new ComputerGame(23.5f, params1);
        ComputerGameParams params2 = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(), "desc", 16);
        ComputerGame game2 = new ComputerGame(25.5f, params2);
        assertFalse(gameStore.platformsSatisfied(game1, game2));
    }

    public void testPlatformsNotSatisfiedBothGamesHavePlatforms(){
        ComputerGameParams params1 = new ComputerGameParams("a", new ArrayList<Genre>(Arrays.asList(Genre.SHOOTER)), new ArrayList<Platform>(Arrays.asList(Platform.WINDOWS_7)), "desc", 14);
        ComputerGame game1 = new ComputerGame(23.5f, params1);
        ComputerGameParams params2 = new ComputerGameParams("b", new ArrayList<Genre>(Arrays.asList(Genre.ACTION)), new ArrayList<Platform>(Arrays.asList(Platform.WINDOWS_10)), "desc", 16);
        ComputerGame game2 = new ComputerGame(25.5f, params2);
        assertFalse(gameStore.platformsSatisfied(game1, game2));
    }
}
