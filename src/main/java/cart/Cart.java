package cart;

import game.ComputerGame;

import java.util.*;

public class Cart {
    private ArrayList<ComputerGame> games;
    private PaymentStrategy paymentStrategy;

    public Cart(ArrayList<ComputerGame> games, PaymentStrategy paymentStrategy) {
        this.games = games;
        this.paymentStrategy = paymentStrategy;
    }

    public ArrayList<ComputerGame> getGames() {
        return games;
    }

    public void setGames(ArrayList<ComputerGame> games) {
        this.games = games;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}


