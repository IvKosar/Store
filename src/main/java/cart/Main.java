package cart;

import cart.cartDecorator.BonusDecorator;
import cart.cartDecorator.DiscountDecorator;
import cart.delivery.DeliveryDHL;
import cart.payment.PayPalStrategy;
import game.ComputerGame;
import game.ComputerGameParams;
import game.Genre;
import game.Platform;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        ComputerGamesCart cart = new ComputerGamesCart(new PayPalStrategy(), new DeliveryDHL());
        Cart decorator = new BonusDecorator(new DiscountDecorator(cart));
        System.out.println(String.format("%b", decorator.ship()));

    }
}
