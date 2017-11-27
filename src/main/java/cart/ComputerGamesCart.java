package cart;

import cart.delivery.DeliveryStrategy;
import cart.payment.PaymentStrategy;
import game.ComputerGame;
import user.Observable;
import user.Observer;

import java.util.*;

public class ComputerGamesCart extends Observable implements Cart{
    private ArrayList<ComputerGame> games;
    private double totalPrice;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;

    public ComputerGamesCart(PaymentStrategy paymentStrategy, DeliveryStrategy deliveryStrategy) {
        this.games = new ArrayList<>();
        this.totalPrice = 0.0;
        this.paymentStrategy = paymentStrategy;
        this.deliveryStrategy = deliveryStrategy;
    }

    @Override
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean ship(){
        System.out.println("The package is shipping!");
        return true;
    }

    public ArrayList<ComputerGame> getGames() {
        return games;
    }

    public void addGame(ComputerGame game){
        this.games.add(game);
        this.setTotalPrice(this.getTotalPrice() + game.getPrice());
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

    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }
}


