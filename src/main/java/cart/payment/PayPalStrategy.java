package cart.payment;

import cart.payment.InvalidPaymentSum;
import cart.payment.PaymentStrategy;

public class PayPalStrategy implements PaymentStrategy {
    public boolean pay(double sum){
        if (sum <= 0){
            throw new InvalidPaymentSum(sum);
        }
        else {
            System.out.println("Your payment by PayPal was successful!");
            return true;
        }
    }
}
