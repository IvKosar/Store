package cart.cartDecorator;

import cart.Cart;
import cart.ComputerGamesCart;
import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;

import java.util.ArrayList;

public class BonusDecorator extends CartDecorator {
    public BonusDecorator(Cart cart){
        super(cart);
    }

    @Override
    public boolean ship(){
        System.out.println("Cool gifts added to your cart!");
        return cart.ship();
    }
}
