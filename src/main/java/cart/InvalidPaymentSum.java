package cart;

public class InvalidPaymentSum extends RuntimeException {
    private double amount;

    public InvalidPaymentSum(double amount){
        super("Payment is declined! The payment sum is less or equal to zero!");
        this.amount = amount;}

    public double getAmount() {
        return amount;
    }


}
