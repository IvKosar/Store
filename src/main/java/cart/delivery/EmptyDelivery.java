package cart.delivery;

class EmptyDelivery extends RuntimeException {
    EmptyDelivery() {
        super("Nothing to deliver!");
    }
}
