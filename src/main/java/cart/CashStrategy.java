package cart;

public class CashStrategy implements PaymentStrategy {
    public boolean pay(double sum){
        if (sum <= 0){
            System.out.println("Payment is declined! The payment sum is less or equal to zero!");
            return false;
        }
        else {
            System.out.println("Your payment by CASH was successful!");
            return true;
        }
    }
}
