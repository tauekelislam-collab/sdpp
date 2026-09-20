package pizza.factorymethod;

import pizza.product.Pizza;

public abstract class PizzaRestaurant {

    public abstract Pizza createPizza();

    public void orderPizza() {
        Pizza pizza = createPizza();

        System.out.println("Order received: " + pizza.getName());
        pizza.prepare();
        System.out.println("Your pizza is ready.");
    }
}