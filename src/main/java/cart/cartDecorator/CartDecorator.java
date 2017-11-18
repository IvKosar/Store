package cart.cartDecorator;

import cart.Cart;

public class CartDecorator {
    protected Cart cart;

    public CartDecorator(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public CartDecorator decorator(Cart cart){
        return new CartDecorator(cart);
    };
}
