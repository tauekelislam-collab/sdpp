package pizza.product;

public class Cola implements Drink {

    @Override
    public String getName() {
        return "Cola";
    }

    @Override
    public void serve() {
        System.out.println("Serving chilled cola.");
    }
}