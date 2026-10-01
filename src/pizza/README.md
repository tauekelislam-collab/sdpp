# Pizza Factory and Bridge Patterns

This Java console application demonstrates Factory Method,
Abstract Factory, and Bridge patterns using a pizza restaurant domain.

## How to Run

Open the project in IntelliJ IDEA, select an installed JDK,
and run the main method in `src/pizza/app/Main.java`.

No external libraries are required.

## Part A — Factory Method

`PizzaRestaurant` declares the factory method `createPizza()`.
Its `orderPizza()` method uses the returned pizza through the
`Pizza` interface.

Restaurant subclasses override `createPizza()` to choose the
concrete pizza.

| Role | Interface or Class |
|---|---|
| Product | Pizza |
| Concrete Products | Pepperoni, Fourseas |
| Creator | PizzaRestaurant |
| Concrete Creators | PepperoniRestaurant, FourseasRestaurant |

The current `Fourseas` class represents the Four Cheese recipe.

The shared ordering process does not need to change when
another restaurant subclass supplies a new pizza type.

## Part B — Abstract Factory

`PizzaMealFactory` declares methods for creating two related
product types: `Pizza` and `Drink`.

Each concrete factory creates a predefined meal family.

| Factory | Pizza | Drink |
|---|---|---|
| PepperoniMealFactory | Pepperoni | Cola |
| FourCheeseMealFactory | Fourseas | Lemonade |

| Role | Interface or Class |
|---|---|
| Abstract Factory | PizzaMealFactory |
| Concrete Factories | PepperoniMealFactory, FourCheeseMealFactory |
| Abstract Products | Pizza, Drink |
| Concrete Products | Pepperoni, Fourseas, Cola, Lemonade |
| Client | MealOrder |

`MealOrder` uses factory and product interfaces.
`Main` selects the concrete factories during application setup.

## Part C — Bridge Pattern

Assignment 3 adds a new independent dimension to the pizza application:
the order type is separated from the way the order is fulfilled.

| Bridge Role | Class |
|---|---|
| Abstraction | Order |
| Refined Abstractions | PersonalOrder, FamilyOrder |
| Implementor | Fulfillment |
| Concrete Implementors | DeliveryFulfillment, DineInFulfillment |
| Client | Main |

The `Order` abstraction stores a reference to the `Fulfillment`
interface. This composition is the bridge between the two hierarchies.

`Main` also demonstrates runtime switching by creating a
`PersonalOrder` with delivery and then changing the same abstraction
to dine-in without changing the `PersonalOrder` class.

## Clean Code Principles

### 1. Meaningful Names

Names such as `PersonalOrder`, `DeliveryFulfillment`, and
`changeFulfillment()` describe their intent directly.

### 2. Small, Focused Classes

Every Bridge class has one main responsibility:
order classes contain high-level order behavior, while fulfillment
classes contain low-level fulfillment behavior.

### 3. Clear Separation of Responsibilities

The abstraction side does not contain courier or restaurant-serving
details. Those details stay inside concrete implementors.

### 4. Program to an Interface

`Order` depends on the `Fulfillment` interface rather than on
`DeliveryFulfillment` or `DineInFulfillment`.

### 5. Open/Closed Design

A new fulfillment method can implement `Fulfillment` without changing
`Order`, `PersonalOrder`, or `FamilyOrder`.

### 6. Defensive Validation

`Order` rejects a null fulfillment with a clear exception message,
preventing an invalid Bridge configuration.

## Manual Verification

Running `Main` demonstrates:

- Pepperoni creation through Factory Method.
- Four Cheese creation through Factory Method.
- A Pepperoni and Cola meal through Abstract Factory.
- A Four Cheese and Lemonade meal through Abstract Factory.
- Personal order with delivery.
- Runtime switch of the same personal order to dine-in.
- Family order with delivery.
- Normal program completion.

## Limitations

This is a console demonstration. Preparation, serving, and fulfillment
are represented by printed messages. The application does not implement
payments, inventory, real courier tracking, or restaurant table management.
