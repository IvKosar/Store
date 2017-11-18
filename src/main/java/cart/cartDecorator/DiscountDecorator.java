package cart.cartDecorator;

import cart.Cart;

public class DiscountDecorator extends CartDecorator {
    public DiscountDecorator(Cart cart) {
        super(cart);
    }

    public boolean computeTotalPrice(float bonus){
        //float bonus = 10f;
        this.cart.setTotalPrice(this.cart.getTotalPrice() - bonus);
        return true;
    }
}
