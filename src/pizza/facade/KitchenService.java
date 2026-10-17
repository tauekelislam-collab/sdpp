package pizza.facade;

import java.util.Objects;
import pizza.product.Pizza;

public class KitchenService {
    private final boolean open;
    private int preparedPizzas;

    public KitchenService(boolean open) {
        this.open = open;
    }

    public void prepare(Pizza pizza, int quantity) {
        Objects.requireNonNull(pizza, "Pizza must not be null.");
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (!open) {
            throw new IllegalStateException("Kitchen is closed.");
        }
        int updatedCount = Math.addExact(preparedPizzas, quantity);
        for (int i = 0; i < quantity; i++) {
            pizza.prepare();
        }
        preparedPizzas = updatedCount;
    }

    public int getPreparedPizzas() {
        return preparedPizzas;
    }
}
