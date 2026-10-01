# Assignment #3 — Bridge Pattern

## Topic

**Pizza Order Fulfillment System**

This topic extends the existing pizza project but does not reuse the
Bridge examples from Lecture 4 such as shapes/renderers, remote/devices,
or vehicle/workshop.

> The assignment also requires the topic to be unique within the group.
> Confirm that no classmate is using the same topic.

## Design Goal

The system has two independent dimensions of variation:

1. **Order type** — personal or family.
2. **Fulfillment method** — delivery or dine-in.

Without Bridge, combinations such as `PersonalDeliveryOrder`,
`PersonalDineInOrder`, `FamilyDeliveryOrder`, and
`FamilyDineInOrder` would require separate classes.

Bridge separates these dimensions and connects them by composition.

## Bridge Roles

| Bridge Role | Project Class |
|---|---|
| Abstraction | `Order` |
| Refined Abstraction 1 | `PersonalOrder` |
| Refined Abstraction 2 | `FamilyOrder` |
| Implementor | `Fulfillment` |
| Concrete Implementor 1 | `DeliveryFulfillment` |
| Concrete Implementor 2 | `DineInFulfillment` |
| Client | `Main` |

## Structure

```text
                 Order
                   |
          -------------------
          |                 |
   PersonalOrder       FamilyOrder
          |
          | composition / bridge
          v
              Fulfillment
              /         \
             /           \
DeliveryFulfillment   DineInFulfillment
```

The field inside `Order` is typed as `Fulfillment`, not as one
specific concrete implementation. This keeps the abstraction independent
from implementation details.

## Runtime Switching

The client demonstrates runtime flexibility:

```java
Order personalOrder =
        new PersonalOrder(new DeliveryFulfillment());

personalOrder.process();

personalOrder.changeFulfillment(
        new DineInFulfillment()
);

personalOrder.process();
```

The same `PersonalOrder` object changes from delivery to dine-in.
The abstraction class does not need to change.

## Clean Code Justification

1. **Meaningful names** — class and method names describe domain roles.
2. **Small focused classes** — each class has one responsibility.
3. **Separation of abstraction and implementation** — order logic and
   fulfillment logic do not leak into each other.
4. **Dependency on abstraction** — `Order` depends on the
   `Fulfillment` interface instead of concrete classes.
5. **No duplicated combination classes** — Bridge avoids separate classes
   for every order-type/fulfillment combination.
6. **Open/Closed Principle** — new order types or fulfillment methods can
   be added without modifying the opposite hierarchy.
7. **Defensive validation** — null fulfillment is rejected with a clear
   exception message.

## How to Run

Run:

```text
src/pizza/app/Main.java
```

The Bridge section of the output should include:

```text
=== Bridge Pattern ===
Preparing a personal pizza order...
Personal order will be delivered by courier.
Switching the same order to another implementation...
Preparing a personal pizza order...
Personal order will be served in the restaurant.

Preparing a family pizza order...
Family order will be delivered by courier.
```

## Defense Notes

A short explanation for defense:

> Bridge separates an abstraction from its implementation so both can
> vary independently. In my project, `Order` is the abstraction and
> `Fulfillment` is the implementor. `PersonalOrder` and
> `FamilyOrder` are refined abstractions. `DeliveryFulfillment` and
> `DineInFulfillment` are concrete implementors. The reference from
> `Order` to `Fulfillment` is the bridge. The client can switch the
> implementation at runtime without changing the abstraction.
