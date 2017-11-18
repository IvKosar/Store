package cart.cartDecorator;

import cart.Cart;
import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;

import java.util.ArrayList;

public class BonusDecorator extends CartDecorator {
    public BonusDecorator(Cart cart){
        super(cart);
    }

    public boolean ship(){
        ComputerGameParams bonusGameParams = new ComputerGameParams("Bonus Game", new ArrayList<Genre>(), new ArrayList<Platform>(), "Bonus Game Desc", 14);
        ComputerGame bonusGame = new ComputerGame(0.0f, bonusGameParams);
        this.cart.addGame(bonusGame);
        return true;
    }
}
