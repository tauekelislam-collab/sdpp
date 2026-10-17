package pizza.app;

import pizza.facade.PizzaOrderFacade;

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

        System.out.println("\n=== Facade Pattern ===");
        PizzaOrderFacade restaurant = new PizzaOrderFacade(5, 20000, true);
        System.out.println(restaurant.placeOrder("pepperoni", 2));
        System.out.println(restaurant.placeOrder("four cheese", 1));

        try {
            restaurant.placeOrder("pepperoni", 10);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        PizzaOrderFacade lowBalance = new PizzaOrderFacade(5, 1000, true);
        try {
            lowBalance.placeOrder("pepperoni", 1);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        PizzaOrderFacade closedKitchen = new PizzaOrderFacade(5, 20000, false);
        try {
            closedKitchen.placeOrder("pepperoni", 1);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
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
