# Assignment 5 - Strategy

Topic: pizza delivery cost calculation. Distance is a non-negative whole number in kilometres; prices are in KZT.

| Component | Implementation |
| --- | --- |
| Strategy interface | DeliveryStrategy.calculateCost(int distanceKm) |
| Concrete strategies | StandardDelivery, ExpressDelivery, PickupDelivery |
| Context | DeliveryService stores the strategy and delegates calculation |
| Client | pizza.app.Main selects and switches strategies on the same service at runtime |

Standard delivery: 500 + 100 * distance. Express: 1000 + 200 * distance. Pickup: 0.

## Clean Code principles

1. Meaningful names: StandardDelivery, ExpressDelivery and calculateCost describe their purpose; named constants explain the fees.
2. Single Responsibility: each strategy implements only its own pricing algorithm; Main handles demonstration output.
3. Polymorphism replaces branching: DeliveryService calls strategy.calculateCost without if/switch on strategy type. Its distance check validates input only.
4. Depend on abstractions: DeliveryService refers to DeliveryStrategy, with no knowledge of concrete strategies or their formulas.
5. Open/Closed Principle: to extend the original StandardDelivery and ExpressDelivery pair, PickupDelivery implements the same interface. Only the client's configuration needs the new strategy; the context and existing strategies need no changes. Further strategies can be added the same way.

## Run

Run pizza.app.Main in IntelliJ IDEA, or from the repository root:

```sh
javac -d out -sourcepath src src/pizza/app/Main.java
java -cp out pizza.app.Main
```

The Strategy section appears after the previous pattern demonstrations:


```text
Standard: 1000 KZT
Express: 2000 KZT
Pickup: 0 KZT
```
