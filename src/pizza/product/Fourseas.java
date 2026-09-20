package pizza.product;

public class Fourseas implements Pizza {

    @Override
    public String getName() {
        return "Four Cheese Pizza";
    }

    @Override
    public void prepare() {
        System.out.println(
                "Preparing pizza with mozzarella, "
                        + "gorgonzola, parmesan and cheddar."
        );
    }
}