package cart.cartDecorator;

import cart.Cart;

public class DiscountDecorator extends CartDecorator {
    private static double discount = 1;

    public DiscountDecorator(Cart cart) {
        super(cart);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double newDiscount) {
        discount = newDiscount;
    }

    @Override
    public double getTotalPrice(){
        double result = this.cart.getTotalPrice() - this.getDiscount();
        this.cart.setTotalPrice(result);
        return result;
    }
}
