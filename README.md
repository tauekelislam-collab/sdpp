Assignment 1 — Builder Pattern: Custom Pizza Ordering System
Domain Description
This project implements the Builder Creational Pattern in Java for a Pizza Ordering System. A pizza order is a complex object consisting of multiple configurable parameters (size, dough type, sauce, extra crust, toppings). The Builder pattern allows constructing pizza objects step-by-step using a Fluent API, validating business logic before object creation, and reusing standard pizza recipes using a Director.

Technical Architecture
Product (PizzaOrder): Represents the final immutable pizza object.
Builder (PizzaBuilder): Provides granular step-by-step configuration methods with method chaining (return this;).
Director (Director): Encapsulates creation of standard configurations (Pepperoni, Four Cheese).
Client (Main): Demonstrates custom pizza construction, director usage, and error validation handling.
Clean Code Principles Justification
1. Meaningful, Intention-Revealing Names
Description: Classes, variables, and methods are named clearly based on domain concepts without cryptic abbreviations.
Code Excerpt:
// BEFORE (bad):
public PizzaBuilder setD(DoughType d) { this.d = d; return this; }

// AFTER (applied):
public PizzaBuilder setDoughType(DoughType doughType) {
    this.doughType = doughType;
    return this;
}
Small Methods with Single Responsibility (Do One Thing)
// BEFORE (bad - build method does construction AND complex validation logic together):

public PizzaOrder build() { if (size == null) throw new IllegalStateException(); if (toppings.isEmpty()) throw new IllegalStateException(); return new PizzaOrder(...); }

// AFTER (applied - separate validation helper method):

public PizzaOrder build() { validateOrderState(); return new PizzaOrder(size, doughType, sauceType, extraCheese, extraCrust, new ArrayList<>(toppings)); }

Validated Construction (Throw Clear Exceptions)
private void validateOrderState() { if (size == null) { throw new IllegalStateException("Pizza size must be explicitly specified."); } if (toppings.isEmpty()) { throw new IllegalStateException("Pizza must contain at least one topping."); } }

No Magic Strings/Numbers (Using Enums & Strongly Typed Parameters)
// BEFORE (bad):

builder.setSize(2); // What does 2 mean? Large? Medium? builder.setDough("thin_crust_v2");

// AFTER (applied):

builder.setSize(Size.LARGE); builder.setDoughType(DoughType.THIN);

Argument Discipline (Minimal Function Arguments & Fluent Method Chaining)
// BEFORE (bad - long parameter list with flag arguments):

public PizzaOrder createPizza(Size s, DoughType d, SauceType sauce, boolean extraCheese, boolean extraCrust, List t)

// AFTER (applied - fluent API with single-argument setter methods):

public PizzaBuilder setExtraCheese(boolean extraCheese) { this.extraCheese = extraCheese; return this; }
