package pizza.visitor;

public interface MenuVisitor {
    void visitPizza(PizzaItem pizza);
    void visitDrink(DrinkItem drink);
}
