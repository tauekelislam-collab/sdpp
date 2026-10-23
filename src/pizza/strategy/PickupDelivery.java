package pizza.strategy;

public class PickupDelivery implements DeliveryStrategy {
    @Override
    public int calculateCost(int distanceKm) {
        return 0;
    }
}
