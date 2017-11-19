package cart.cartDecorator;

import cart.Cart;

public abstract class CartDecorator implements Cart {
    protected Cart cart;

    public CartDecorator(Cart cart){this.cart = cart;}

    public Cart getComputerGamesCart() {
        return cart;
    }

    @Override
    public void setTotalPrice(double price){this.cart.setTotalPrice(price);}

    @Override
    public boolean ship(){
        return cart.ship();
    }

    @Override
    public double getTotalPrice(){
        return cart.getTotalPrice();
    }
}
