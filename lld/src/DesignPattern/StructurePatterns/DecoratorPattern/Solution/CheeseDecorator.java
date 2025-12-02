package DesignPattern.StructurePatterns.DecoratorPattern.Solution;

public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return decoratedPizza.getDescription()+", Cheese";
    }
    public double getPrice() {
        return decoratedPizza.getPrice()+1.0;
    }
}
