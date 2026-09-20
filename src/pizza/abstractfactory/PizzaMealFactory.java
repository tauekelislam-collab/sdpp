package pizza.abstractfactory;

import pizza.product.Drink;
import pizza.product.Pizza;

public interface PizzaMealFactory {
    Pizza createPizza();
    Drink createDrink();
}