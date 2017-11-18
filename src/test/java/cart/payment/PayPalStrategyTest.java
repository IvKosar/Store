package cart.payment;

import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PayPalStrategyTest {
    private static PaymentStrategy paypalStrategy = new PayPalStrategy();

    @Test
    public void testValidPayment(){
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        ArrayList<ComputerGame> games = new ArrayList<>(Arrays.asList(game));
        assertTrue(paypalStrategy.pay(23.5));
    }

    @Test(expected = InvalidPaymentSum.class)
    public void testInvalidPayment(){
        paypalStrategy.pay(-23.5);
    }
}