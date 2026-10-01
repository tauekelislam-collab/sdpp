package pizza.bridge;

public class PersonalOrder extends Order {

    public PersonalOrder(Fulfillment fulfillment) {
        super(fulfillment);
    }

    @Override
    public void process() {
        System.out.println("Preparing a personal pizza order...");
        getFulfillment().fulfill("Personal order");
    }
}
