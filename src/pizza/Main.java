package pizza;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 1. Custom Pizza Order via Fluent Builder ===");
        PizzaOrder customPizza = new PizzaBuilder()
                .setSize(Size.LARGE)
                .setDoughType(DoughType.CHEESE_CRUST)
                .setSauceType(SauceType.BARBECUE)
                .addTopping("Chicken")
                .addTopping("Bacon")
                .addTopping("Onions")
                .setExtraCrust(true)
                .build();

        System.out.println("Custom Pizza: " + customPizza);

        System.out.println("\n=== 2. Predefined Recipes via Director ===");
        Director director = new Director();

        PizzaOrder pepperoni = director.makePepperoni(new PizzaBuilder());
        System.out.println("Pepperoni: " + pepperoni);

        PizzaOrder fourCheese = director.makeFourCheese(new PizzaBuilder());
        System.out.println("Four Cheese: " + fourCheese);

        System.out.println("\n=== 3. Testing Order Validation ===");
        try {
            new PizzaBuilder()
                    .setSize(Size.SMALL)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation Caught: " + e.getMessage());
        }

        try {
            new PizzaBuilder()
                    .addTopping("Mushrooms")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation Caught: " + e.getMessage());
        }
    }
}