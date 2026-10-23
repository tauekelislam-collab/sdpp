package pizza.strategy;

public class StandardDelivery implements DeliveryStrategy {
    private static final int BASE_FEE = 500;
    private static final int RATE_PER_KM = 100;

    @Override
    public int calculateCost(int distanceKm) {
        return BASE_FEE + distanceKm * RATE_PER_KM;
    }
}
