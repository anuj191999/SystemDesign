package DesignPattern.StructurePatterns.DecoratorPattern.Solution;

public class PizzaDecorator implements Pizza{
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza) {
        decoratedPizza = pizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public double getPrice() {
        return decoratedPizza.getPrice();
    }
}
