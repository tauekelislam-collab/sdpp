# Pizza Factory Patterns

This Java console application demonstrates Factory Method and
Abstract Factory using a pizza restaurant.

## How to Run

Open the project in IntelliJ IDEA, select an installed JDK,
and run the main method in src/pizza/app/Main.java.

No external libraries are required.

## Part A — Factory Method

PizzaRestaurant declares the factory method createPizza().
Its orderPizza() method uses the returned pizza through the
Pizza interface.

Restaurant subclasses override createPizza() to choose the
concrete pizza.

| Role | Interface or Class |
|---|---|
| Product | Pizza |
| Concrete Products | Pepperoni, Fourseas |
| Creator | PizzaRestaurant |
| Concrete Creators | PepperoniRestaurant, FourseasRestaurant |

The current Fourseas class represents the Four Cheese recipe.

The shared ordering process does not need to change when
another restaurant subclass supplies a new pizza type.

## Part B — Abstract Factory

PizzaMealFactory declares methods for creating two related
product types: Pizza and Drink.

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

MealOrder uses factory and product interfaces.
Main selects the concrete factories during application setup.

## Clean Code Principles

### 1. Meaningful Names

```java
Pizza createPizza();
Drink createDrink();
```

These method names describe exactly which products they create.
They communicate more clearly than names such as make() or get().

### 2. Small Methods

```java
@Override
public Drink createDrink() {
    return new Cola();
}
```

This method performs one task: creating a drink.
It does not also serve the meal or print order information.

### 3. Avoid Duplicated Logic

```java
public void orderPizza() {
    Pizza pizza = createPizza();

    System.out.println("Order received: " + pizza.getName());
    pizza.prepare();
    System.out.println("Your pizza is ready.");
}
```

The ordering process is defined once in PizzaRestaurant.
Both restaurant subclasses inherit it instead of copying it.

### 4. Clear Validation and Error Messages

```java
if (factory == null) {
    throw new IllegalArgumentException(
            "Meal factory must not be null."
    );
}
```

The MealOrder constructor rejects an invalid factory argument
before attempting to use it. The message explains the problem.

### 5. Encapsulation

```java
private final Pizza pizza;
private final Drink drink;
```

MealOrder keeps its product references private, so other classes
cannot directly replace them. The final modifier prevents these
references from being reassigned after initialization.

This protects the selected meal composition. It does not, by
itself, make the product objects immutable.

## Manual Verification

Running Main demonstrated:

- Pepperoni creation through Factory Method.
- Four Cheese creation through Factory Method.
- A Pepperoni and Cola meal through Abstract Factory.
- A Four Cheese and Lemonade meal through Abstract Factory.
- Normal program completion with exit code 0.

## Limitations

This is a console demonstration. Preparation and serving are
represented by printed messages. The application does not
implement payments, inventory, or delivery.