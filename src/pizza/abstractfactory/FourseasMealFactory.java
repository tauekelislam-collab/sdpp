package pizza.abstractfactory;

import pizza.product.Drink;
import pizza.product.Fourseas;
import pizza.product.Lemonade;
import pizza.product.Pizza;

public class FourseasMealFactory implements PizzaMealFactory {

    @Override
    public Pizza createPizza() {
        return new Fourseas();
    }

    @Override
    public Drink createDrink() {
        return new Lemonade();
    }
}