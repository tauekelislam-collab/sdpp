package pizza;

import java.util.Collections;
import java.util.List;

public final class PizzaOrder {

    private final Size size;
    private final DoughType doughType;
    private final SauceType sauceType;
    private final boolean extraCheese;
    private final boolean extraCrust;
    private final List<String> toppings;

    PizzaOrder(
            Size size,
            DoughType doughType,
            SauceType sauceType,
            boolean extraCheese,
            boolean extraCrust,
            List<String> toppings
    ) {
        this.size = size;
        this.doughType = doughType;
        this.sauceType = sauceType;
        this.extraCheese = extraCheese;
        this.extraCrust = extraCrust;
        this.toppings = Collections.unmodifiableList(toppings);
    }

    public Size getSize() {
        return size;
    }

    public DoughType getDoughType() {
        return doughType;
    }

    public SauceType getSauceType() {
        return sauceType;
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public boolean hasExtraCrust() {
        return extraCrust;
    }

    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "size=" + size +
                ", doughType=" + doughType +
                ", sauceType=" + sauceType +
                ", extraCheese=" + extraCheese +
                ", extraCrust=" + extraCrust +
                ", toppings=" + toppings +
                '}';
    }
}