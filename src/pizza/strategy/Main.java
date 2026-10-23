package pizza.strategy;

public class Main {
    public static void main(String[] args) {
        int distanceKm = 5;
        DeliveryService delivery = new DeliveryService(new StandardDelivery());
        System.out.println("Standard: " + delivery.calculateCost(distanceKm) + " KZT");

        delivery.setStrategy(new ExpressDelivery());
        System.out.println("Express: " + delivery.calculateCost(distanceKm) + " KZT");

        delivery.setStrategy(new PickupDelivery());
        System.out.println("Pickup: " + delivery.calculateCost(distanceKm) + " KZT");
    }
}
