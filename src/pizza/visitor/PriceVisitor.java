package pizza.visitor;

public class PriceVisitor implements MenuVisitor {
    private int totalPrice;

    @Override
    public void visitPizza(PizzaItem pizza) {
        totalPrice += pizza.getPrice();
    }

    @Override
    public void visitDrink(DrinkItem drink) {
        totalPrice += drink.getPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
