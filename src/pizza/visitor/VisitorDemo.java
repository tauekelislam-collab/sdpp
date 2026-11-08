package pizza.visitor;

import java.util.Arrays;
import java.util.List;

public class VisitorDemo {
    public static void run() {
        System.out.println("\n=== Visitor Pattern: Pizza Order Analysis ===");

        List<MenuItem> order = Arrays.asList(
                new PizzaItem("Pepperoni", 3000, 15),
                new PizzaItem("Four Cheese", 3500, 20),
                new DrinkItem("Cola", 700, 2)
        );

        PriceVisitor priceVisitor = new PriceVisitor();
        PreparationTimeVisitor timeVisitor = new PreparationTimeVisitor();

        for (MenuItem item : order) {
            item.accept(priceVisitor);
            item.accept(timeVisitor);
        }

        System.out.println("Total price: " + priceVisitor.getTotalPrice() + " KZT");
        System.out.println("Total preparation time: " + timeVisitor.getTotalMinutes() + " minutes");
    }
}
