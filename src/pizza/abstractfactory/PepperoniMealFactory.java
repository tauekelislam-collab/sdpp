package pizza.abstractfactory;

import pizza.product.Cola;
import pizza.product.Drink;
import pizza.product.Pepperoni;
import pizza.product.Pizza;

public class PepperoniMealFactory implements PizzaMealFactory {

    @Override
    public Pizza createPizza() {
        return new Pepperoni();
    }

    @Override
    public Drink createDrink() {
        return new Cola();
    }
}