package pizza.bridge;

public class FamilyOrder extends Order {

    public FamilyOrder(Fulfillment fulfillment) {
        super(fulfillment);
    }

    @Override
    public void process() {
        System.out.println("Preparing a family pizza order...");
        getFulfillment().fulfill("Family order");
    }
}
