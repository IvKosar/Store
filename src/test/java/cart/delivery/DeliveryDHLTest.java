package cart.delivery;

import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DeliveryDHLTest {
    private static DeliveryStrategy dhlStrategy = new DeliveryDHL();

    @Test
    public void testValidDelivery(){
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        ArrayList<ComputerGame> games = new ArrayList<>(Arrays.asList(game));
        assertTrue(dhlStrategy.deliver(games));
    }

    @Test(expected = EmptyDelivery.class)
    public void testEmptyDelivery(){
        dhlStrategy.deliver(new ArrayList<ComputerGame>());
    }
}