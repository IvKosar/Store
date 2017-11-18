package cart.cartDecorator;

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
import java.util.Arrays;

import static org.junit.Assert.*;

public class BonusDecoratorTest {
    private ComputerGamesCart cart;

    @Before
    public void createCart() {
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);

        cart = new ComputerGamesCart(new ArrayList<ComputerGame>(Arrays.asList(game)), new PayPalStrategy(), new DeliveryDHL());
    }

    @Test
    public void testBonus(){
        CartDecorator bonusCart = new BonusDecorator(cart);
        assertTrue(bonusCart.decorator());
    }
}