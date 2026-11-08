package pizza.visitor;

public class DrinkItem implements MenuItem {
    private final String name;
    private final int price;
    private final int preparationMinutes;

    public DrinkItem(String name, int price, int preparationMinutes) {
        this.name = name;
        this.price = price;
        this.preparationMinutes = preparationMinutes;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getPreparationMinutes() { return preparationMinutes; }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visitDrink(this);
    }
}
