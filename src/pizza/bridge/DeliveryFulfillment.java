package pizza.bridge;

public class DeliveryFulfillment implements Fulfillment {

    @Override
    public void fulfill(String orderName) {
        System.out.println(orderName + " will be delivered by courier.");
    }
}
