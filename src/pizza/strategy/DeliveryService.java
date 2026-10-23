package pizza.strategy;

import java.util.Objects;

public class DeliveryService {
    private DeliveryStrategy strategy;

    public DeliveryService(DeliveryStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(DeliveryStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy is required");
    }

    public int calculateCost(int distanceKm) {
        if (distanceKm < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        return strategy.calculateCost(distanceKm);
    }
}
