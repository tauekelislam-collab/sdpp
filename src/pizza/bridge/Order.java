package pizza.bridge;

public abstract class Order {
    private Fulfillment fulfillment;

    protected Order(Fulfillment fulfillment) {
        this.fulfillment = requireFulfillment(fulfillment);
    }

    public final void changeFulfillment(Fulfillment fulfillment) {
        this.fulfillment = requireFulfillment(fulfillment);
    }

    protected final Fulfillment getFulfillment() {
        return fulfillment;
    }

    public abstract void process();

    private static Fulfillment requireFulfillment(Fulfillment fulfillment) {
        if (fulfillment == null) {
            throw new IllegalArgumentException("Fulfillment must not be null.");
        }
        return fulfillment;
    }
}
