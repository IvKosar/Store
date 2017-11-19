package cart.cartDecorator;

import cart.Cart;
import cart.ComputerGamesCart;
import cart.delivery.DeliveryDHL;
import cart.payment.PayPalStrategy;
import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DiscountDecoratorTest {
    private ComputerGamesCart cart;

    @Before
    public void createCart(){
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        cart = new ComputerGamesCart(new PayPalStrategy(), new DeliveryDHL());
        cart.addGame(game);
    }

    @Test
    public void testOneDiscount(){
        Cart discount = new DiscountDecorator(cart);
        discount.getTotalPrice();
        assertEquals(22.0, cart.getTotalPrice(), 0.1);
    }

    @Test
    public void testMultipleDiscounts(){
        Cart discount = new DiscountDecorator(new DiscountDecorator(cart));
        discount.getTotalPrice();
        assertEquals(21.0, cart.getTotalPrice(), 0.1);
    }
}