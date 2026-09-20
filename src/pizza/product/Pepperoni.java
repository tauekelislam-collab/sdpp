package pizza.product;

public class Pepperoni implements Pizza {

    @Override
    public String getName() {
        return "Pepperoni Pizza";
    }

    @Override
    public void prepare() {
        System.out.println(
                "Preparing pizza with tomato sauce, "
                        + "mozzarella and pepperoni."
        );
    }
}