package pizza.product;

public class Lemonade implements Drink {

    @Override
    public String getName() {
        return "Lemonade";
    }

    @Override
    public void serve() {
        System.out.println("Serving fresh lemonade.");
    }
}