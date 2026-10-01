package pizza.bridge;

public class DineInFulfillment implements Fulfillment {

    @Override
    public void fulfill(String orderName) {
        System.out.println(orderName + " will be served in the restaurant.");
    }
}
