package DesignPattern.StructurePatterns.DecoratorPattern.Solution;

public class MushroomDecorator extends PizzaDecorator{
    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription(){
        return decoratedPizza.getDescription()+", Mushroom";
    }

    public double getPrice(){
        return decoratedPizza.getPrice()+2.0;
    }
}
