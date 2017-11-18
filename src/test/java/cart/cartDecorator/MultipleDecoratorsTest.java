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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultipleDecoratorsTest {
    private ComputerGamesCart cart;

    @Before
    public void createCart(){
        ComputerGameParams params = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame game = new ComputerGame(23.0f, params);
        cart = new ComputerGamesCart(new PayPalStrategy(), new DeliveryDHL());
        cart.addGame(game);
    }

    @Test
    public void DiscountOverBonusComputePrice(){
        Cart decorator = new DiscountDecorator(new BonusDecorator(cart));
        decorator.getTotalPrice();
        assertEquals(22.0, cart.getTotalPrice(), 0.1);
    }

    @Test
    public void DiscountOverBonusShip(){
        Cart decorator = new DiscountDecorator(new BonusDecorator(cart));
        assertTrue(decorator.ship());
    }

    @Test
    public void BonusOverDiscountComputePrice(){
        Cart decorator = new BonusDecorator(new DiscountDecorator(cart));
        decorator.getTotalPrice();
        assertEquals(22.0, cart.getTotalPrice(), 0.1);
    }

    @Test
    public void BonusOverDiscountShip(){
        Cart decorator = new BonusDecorator(new DiscountDecorator(cart));
        assertTrue(decorator.ship());
    }

    @Test
    public void DiscountOverBonusOverDiscountComputePrice(){
        Cart decorator = new DiscountDecorator(new BonusDecorator(new DiscountDecorator(cart)));
        decorator.getTotalPrice();
        assertEquals(21.0, cart.getTotalPrice(), 0.1);
    }

    @Test
    public void DiscountOverBonusOverDiscountShip(){
        Cart decorator = new DiscountDecorator(new BonusDecorator(new DiscountDecorator(cart)));
        assertTrue(decorator.ship());
    }

    @Test
    public void BonusOverDiscountOverBonusComputePrice(){
        Cart decorator = new BonusDecorator(new DiscountDecorator(new BonusDecorator(cart)));
        decorator.getTotalPrice();
        assertEquals(22.0, cart.getTotalPrice(), 0.1);
    }

    @Test
    public void BonusOverDiscountOverBonusShip(){
        Cart decorator = new BonusDecorator(new DiscountDecorator(new BonusDecorator(cart)));
        assertTrue(decorator.ship());
    }
}
