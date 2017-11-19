package cart.payment;

import cart.payment.PaymentStrategy;

public class CashStrategy implements PaymentStrategy {
    public boolean pay(double sum){
        if (sum <= 0){
            throw new InvalidPaymentSum(sum);
        }
        else {
            System.out.println("Your payment by CASH was successful!");
            return true;
        }
    }
}
