package pizza.facade;

import pizza.product.Fourseas;
import pizza.product.Pepperoni;
import pizza.product.Pizza;

public class MenuService {
    public int getUnitPrice(String pizzaName) {
        requireKnownPizza(pizzaName);
        return "pepperoni".equalsIgnoreCase(pizzaName) ? 3000 : 3500;
    }

    public Pizza createPizza(String pizzaName) {
        requireKnownPizza(pizzaName);
        return "pepperoni".equalsIgnoreCase(pizzaName)
                ? new Pepperoni() : new Fourseas();
    }

    private void requireKnownPizza(String pizzaName) {
        if (!"pepperoni".equalsIgnoreCase(pizzaName)
                && !"four cheese".equalsIgnoreCase(pizzaName)) {
            throw new IllegalArgumentException("Unknown pizza: " + pizzaName);
        }
    }
}
