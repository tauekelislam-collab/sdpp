package pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {

    private Size size;
    private DoughType doughType = DoughType.TRADITIONAL;
    private SauceType sauceType = SauceType.TOMATO;
    private boolean extraCheese = false;
    private boolean extraCrust = false;
    private final List<String> toppings = new ArrayList<>();

    public PizzaBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder setDoughType(DoughType doughType) {
        this.doughType = doughType;
        return this;
    }

    public PizzaBuilder setSauceType(SauceType sauceType) {
        this.sauceType = sauceType;
        return this;
    }

    public PizzaBuilder setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
        return this;
    }

    public PizzaBuilder setExtraCrust(boolean extraCrust) {
        this.extraCrust = extraCrust;
        return this;
    }

    public PizzaBuilder addTopping(String topping) {
        if (topping != null && !topping.trim().isEmpty()) {
            this.toppings.add(topping.trim());
        }
        return this;
    }

    public PizzaOrder build() {
        validateOrderState();
        return new PizzaOrder(
                size,
                doughType,
                sauceType,
                extraCheese,
                extraCrust,
                new ArrayList<>(toppings)
        );
    }

    private void validateOrderState() {
        if (size == null) {
            throw new IllegalStateException("Pizza size must be explicitly specified.");
        }
        if (toppings.isEmpty()) {
            throw new IllegalStateException("Pizza must contain at least one topping.");
        }
    }
}