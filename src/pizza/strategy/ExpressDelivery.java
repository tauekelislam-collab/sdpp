package pizza.strategy;

public class ExpressDelivery implements DeliveryStrategy {
    private static final int BASE_FEE = 1000;
    private static final int RATE_PER_KM = 200;

    @Override
    public int calculateCost(int distanceKm) {
        return BASE_FEE + distanceKm * RATE_PER_KM;
    }
}
