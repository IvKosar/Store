package cart;

public interface Cart {
    boolean ship();
    void setTotalPrice(double price);
    double getTotalPrice();
}
