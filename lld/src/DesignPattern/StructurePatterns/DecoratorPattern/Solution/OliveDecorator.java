package DesignPattern.StructurePatterns.DecoratorPattern.Solution;

public class OliveDecorator extends PizzaDecorator{

    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return decoratedPizza.getDescription()+", Olive";
    }

    public double getPrice() {
        return decoratedPizza.getPrice()+2.5;
    }
}
