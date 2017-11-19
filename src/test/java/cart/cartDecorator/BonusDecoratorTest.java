package cart.cartDecorator;

import cart.ComputerGamesCart;
import cart.Cart;
import cart.delivery.DeliveryDHL;
import cart.payment.PayPalStrategy;
import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BonusDecoratorTest {
    private ComputerGamesCart cart;

    @Before
    public void createCart() {
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        cart = new ComputerGamesCart(new PayPalStrategy(), new DeliveryDHL());
        cart.addGame(game);
    }

    @Test
    public void testOneBonus(){
        Cart bonusDecorator = new BonusDecorator(cart);
        assertTrue(bonusDecorator.ship());
    }

    @Test
    public void testMultipleBonuses(){
        Cart bonusDecorator = new BonusDecorator(new BonusDecorator(cart));
        assertTrue(bonusDecorator.ship());
    }
}