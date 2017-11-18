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

public class CartTest {
    private Cart cart;

    @Before
    public void createObject(){
        ArrayList<ComputerGame> games = new ArrayList<>();
        PaymentStrategy paymentStrategy = new CashStrategy();
        DeliveryStrategy deliveryStrategy = new DeliveryNovaPoshta();
        cart = new Cart(games, paymentStrategy, deliveryStrategy);
    }
    @Test
    public void getGames() throws Exception {
        assertTrue(new ArrayList<ComputerGame>().equals(cart.getGames()));
    }

    @Test
    public void addGame() throws Exception {
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        ArrayList<ComputerGame> games = new ArrayList<>(Arrays.asList(game));
        cart.addGame(game);
        assertTrue(games.equals(cart.getGames()));
    }

    @Test
    public void setGames() throws Exception {
        ArrayList<ComputerGame> games = new ArrayList<>();
        cart.setGames(games);
        assertTrue(games.equals(cart.getGames()));
    }

    @Test
    public void getTotalPrice() throws Exception {
        assertEquals(0.0f, cart.getTotalPrice(), 0.5);
    }

    @Test
    public void setTotalPrice() throws Exception {
        float newPrice = 30.2f;
        cart.setTotalPrice(newPrice);
        assertEquals(newPrice, cart.getTotalPrice(), 0.5);
    }
}