package pizza.app;

import pizza.abstractfactory.FourseasMealFactory;
import pizza.abstractfactory.PepperoniMealFactory;
import pizza.abstractfactory.PizzaMealFactory;
import pizza.factorymethod.FourseasRestaurant;
import pizza.factorymethod.PepperoniRestaurant;
import pizza.factorymethod.PizzaRestaurant;

public class Main {

    public static void main(String[] args) {
        demonstrateFactoryMethod();
        demonstrateAbstractFactory();
    }

    private static void demonstrateFactoryMethod() {
        System.out.println("=== Factory Method ===");

        PizzaRestaurant pepperoniRestaurant =
                new PepperoniRestaurant();

        pepperoniRestaurant.orderPizza();

        System.out.println();

        PizzaRestaurant fourCheeseRestaurant =
                new FourseasRestaurant();

        fourCheeseRestaurant.orderPizza();
    }

    private static void demonstrateAbstractFactory() {
        System.out.println("\n=== Abstract Factory ===");

        PizzaMealFactory pepperoniFactory =
                new PepperoniMealFactory();

        MealOrder pepperoniMeal = new MealOrder(pepperoniFactory);
        pepperoniMeal.serve();

        System.out.println();

        PizzaMealFactory FourseasMealFactory =
                new FourseasMealFactory();

        MealOrder fourCheeseMeal = new MealOrder(FourseasMealFactory);
        fourCheeseMeal.serve();
    }
}