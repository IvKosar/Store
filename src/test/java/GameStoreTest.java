import game.*;
import store.GameStore;

import org.junit.Before;
import org.junit.Test;
import store.GameStore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

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
    public void testSearchNotFound(){
        ComputerGameParams params = new ComputerGameParams("a", new ArrayList<Genre>(), new ArrayList<Platform>(), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, params);
        assertNull(gameStore.search(searchGame));
    }

    @Test
    public void testSearchFound(){
        ComputerGameParams params = new ComputerGameParams("a", new ArrayList<Genre>(), new ArrayList<Platform>(), "desc", 14);
        ComputerGame searchGame = new ComputerGame(23.5f, params);
        gameStore.add(searchGame);
        assertEquals(searchGame, gameStore.search(searchGame));
    }
}
