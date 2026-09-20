package pizza.app;

import pizza.abstractfactory.PizzaMealFactory;
import pizza.product.Drink;
import pizza.product.Pizza;

public class MealOrder {

    private final Pizza pizza;
    private final Drink drink;

    public MealOrder(PizzaMealFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException(
                    "Meal factory must not be null."
            );
        }

        pizza = factory.createPizza();
        drink = factory.createDrink();
    }

    public void serve() {
        pizza.prepare();
        drink.serve();

        System.out.println(
                "Meal ready: " + pizza.getName()
                        + " + " + drink.getName()
        );
    }
}