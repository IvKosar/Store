package cart;

import cart.delivery.DeliveryStrategy;
import cart.payment.PaymentStrategy;
import game.ComputerGame;

import java.util.*;

public class ComputerGamesCart{
    private ArrayList<ComputerGame> games;
    private double totalPrice;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;

    public ComputerGamesCart(ArrayList<ComputerGame> games, PaymentStrategy paymentStrategy, DeliveryStrategy deliveryStrategy) {
        this.games = games;
        this.totalPrice = computeTotalPrice();
        this.paymentStrategy = paymentStrategy;
        this.deliveryStrategy = deliveryStrategy;
    }

    private double computeTotalPrice() {
        float price = 0f;
        for (ComputerGame game : games){
            price += game.getPrice();
        }
        return price;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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


