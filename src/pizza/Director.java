package pizza;

public class Director {

    public PizzaOrder makePepperoni(PizzaBuilder builder) {
        return builder
                .setSize(Size.MEDIUM)
                .setDoughType(DoughType.TRADITIONAL)
                .setSauceType(SauceType.TOMATO)
                .addTopping("Pepperoni")
                .addTopping("Mozzarella")
                .build();
    }

    public PizzaOrder makeFourCheese(PizzaBuilder builder) {
        return builder
                .setSize(Size.LARGE)
                .setDoughType(DoughType.THIN)
                .setSauceType(SauceType.CREAMY_GARLIC)
                .setExtraCheese(true)
                .addTopping("Mozzarella")
                .addTopping("Gorgonzola")
                .addTopping("Parmesan")
                .addTopping("Cheddar")
                .build();
    }
}