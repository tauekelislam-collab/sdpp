package pizza.visitor;

public interface MenuItem {
    void accept(MenuVisitor visitor);
}
