# Assignment 4 — Facade

Topic: pizza order checkout. Run pizza.app.Main; the final section demonstrates Facade.

Four subsystem classes: MenuService (recipes/prices), InventoryService
(reservation), PaymentService (simulated wallet), KitchenService (preparation).
PizzaOrderFacade coordinates them via placeOrder(name, quantity).
Main uses only the facade for this demonstration. Subsystems remain public and
independently usable and have no reference to the facade.

## Five Clean Code principles

1. Meaningful names: placeOrder, reserve, charge and refund explain their purpose.
2. Single Responsibility: each service owns one task; the facade only coordinates.
3. Encapsulation: the public ordering method accepts a pizza name and quantity,
   and returns confirmation without exposing subsystem objects.
4. Small focused methods/classes: validation and each operation have limited scope.
5. Proper error handling: insufficient payment releases reserved stock; a closed
   kitchen also refunds the payment. Exceptions preserve the original cause.

Prices and balances use whole KZT. This is a single-threaded, in-memory learning
example with one wallet per facade and generic ingredient portions. Existing
pizza products demonstrate preparation through printed messages; this does not
simulate real payment or undo physical cooking.

The topic is different from the Lecture 6 home theater, video conversion and
hotel-menu examples. Group uniqueness must be checked with classmates.
