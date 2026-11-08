package pizza.visitor;

public class PreparationTimeVisitor implements MenuVisitor {
    private int totalMinutes;

    @Override
    public void visitPizza(PizzaItem pizza) {
        totalMinutes += pizza.getPreparationMinutes();
    }

    @Override
    public void visitDrink(DrinkItem drink) {
        totalMinutes += drink.getPreparationMinutes();
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }
}
