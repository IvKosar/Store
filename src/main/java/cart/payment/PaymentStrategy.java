package cart.payment;

public interface PaymentStrategy {
    boolean pay(double sum) throws InvalidPaymentSum;
}
