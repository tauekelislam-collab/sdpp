package pizza.facade;

import pizza.product.Pizza;

public class PizzaOrderFacade {
    private final MenuService menu;
    private final InventoryService inventory;
    private final PaymentService payment;
    private final KitchenService kitchen;

    public PizzaOrderFacade(int portions, int balance, boolean kitchenOpen) {
        menu = new MenuService();
        inventory = new InventoryService(portions);
        payment = new PaymentService(balance);
        kitchen = new KitchenService(kitchenOpen);
    }

    public String placeOrder(String pizzaName, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        int totalPrice = Math.multiplyExact(menu.getUnitPrice(pizzaName), quantity);
        Pizza pizza = menu.createPizza(pizzaName);
        boolean reserved = false;
        boolean paid = false;
        try {
            inventory.reserve(quantity);
            reserved = true;
            payment.charge(totalPrice);
            paid = true;
            kitchen.prepare(pizza, quantity);
            return quantity + " x " + pizza.getName() + ": " + totalPrice + " KZT";
        } catch (RuntimeException e) {
            if (paid) {
                payment.refund(totalPrice);
            }
            if (reserved) {
                inventory.release(quantity);
            }
            throw new IllegalStateException("Cannot place order: " + e.getMessage(), e);
        }
    }
}
