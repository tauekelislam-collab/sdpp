package pizza.app;

import pizza.abstractfactory.FourseasMealFactory;
import pizza.abstractfactory.PepperoniMealFactory;
import pizza.abstractfactory.PizzaMealFactory;
import pizza.bridge.DeliveryFulfillment;
import pizza.bridge.DineInFulfillment;
import pizza.bridge.FamilyOrder;
import pizza.bridge.Fulfillment;
import pizza.bridge.Order;
import pizza.bridge.PersonalOrder;
import pizza.factorymethod.FourseasRestaurant;
import pizza.factorymethod.PepperoniRestaurant;
import pizza.factorymethod.PizzaRestaurant;

public class Main {

    public static void main(String[] args) {
        demonstrateFactoryMethod();
        demonstrateAbstractFactory();
        demonstrateBridge();
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

        PizzaMealFactory fourCheeseMealFactory =
                new FourseasMealFactory();
        MealOrder fourCheeseMeal = new MealOrder(fourCheeseMealFactory);
        fourCheeseMeal.serve();
    }

    private static void demonstrateBridge() {
        System.out.println("\n=== Bridge Pattern ===");

        Fulfillment delivery = new DeliveryFulfillment();
        Fulfillment dineIn = new DineInFulfillment();

        Order personalOrder = new PersonalOrder(delivery);
        personalOrder.process();

        System.out.println(
                "Switching the same order to another implementation..."
        );
        personalOrder.changeFulfillment(dineIn);
        personalOrder.process();

        System.out.println();

        Order familyOrder = new FamilyOrder(delivery);
        familyOrder.process();
    }
}
