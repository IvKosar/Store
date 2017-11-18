package cart.delivery;

import cart.payment.PaymentStrategy;
import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DeliveryNovaPoshtaTest {
    private static DeliveryStrategy novaposhtaStrategy = new DeliveryNovaPoshta();

    @Test
    public void testValidDelivery(){
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        ArrayList<ComputerGame> games = new ArrayList<>(Arrays.asList(game));
        assertTrue(novaposhtaStrategy.deliver(games));
    }

    @Test(expected = EmptyDelivery.class)
    public void testEmptyDelivery(){
        novaposhtaStrategy.deliver(new ArrayList<ComputerGame>());
    }
}