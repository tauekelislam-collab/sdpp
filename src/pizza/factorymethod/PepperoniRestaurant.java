package pizza.factorymethod;

import pizza.product.Pepperoni;
import pizza.product.Pizza;

public class PepperoniRestaurant extends PizzaRestaurant {

    @Override
    public Pizza createPizza() {
        return new Pepperoni();
    }
}