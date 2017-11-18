package cart;

import cart.delivery.DeliveryNovaPoshta;
import cart.delivery.DeliveryStrategy;
import cart.payment.CashStrategy;
import cart.payment.PaymentStrategy;
import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ComputerGamesCartTest {
    private ComputerGamesCart computerGamesCart;

    @Before
    public void createObject(){
        ArrayList<ComputerGame> games = new ArrayList<>();
        PaymentStrategy paymentStrategy = new CashStrategy();
        DeliveryStrategy deliveryStrategy = new DeliveryNovaPoshta();
        computerGamesCart = new ComputerGamesCart(games, paymentStrategy, deliveryStrategy);
    }
    @Test
    public void getGames() throws Exception {
        assertTrue(new ArrayList<ComputerGame>().equals(computerGamesCart.getGames()));
    }

    @Test
    public void addGame() throws Exception {
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        ArrayList<ComputerGame> games = new ArrayList<>(Arrays.asList(game));
        computerGamesCart.addGame(game);
        assertTrue(games.equals(computerGamesCart.getGames()));
    }

    @Test
    public void setGames() throws Exception {
        ArrayList<ComputerGame> games = new ArrayList<>();
        computerGamesCart.setGames(games);
        assertTrue(games.equals(computerGamesCart.getGames()));
    }

    @Test
    public void getTotalPrice() throws Exception {
        assertEquals(0.0f, computerGamesCart.getTotalPrice(), 0.5);
    }

    @Test
    public void setTotalPrice() throws Exception {
        float newPrice = 30.2f;
        computerGamesCart.setTotalPrice(newPrice);
        assertEquals(newPrice, computerGamesCart.getTotalPrice(), 0.5);
    }
}