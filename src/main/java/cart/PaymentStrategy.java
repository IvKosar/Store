package cart;

public interface PaymentStrategy {
    boolean pay(double sum) throws InvalidPaymentSum;
}
