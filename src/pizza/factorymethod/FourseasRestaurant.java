package pizza.factorymethod;

import pizza.product.Fourseas;
import pizza.product.Pizza;

public class FourseasRestaurant extends PizzaRestaurant {

    @Override
    public Pizza createPizza() {
        return new Fourseas();
    }
}