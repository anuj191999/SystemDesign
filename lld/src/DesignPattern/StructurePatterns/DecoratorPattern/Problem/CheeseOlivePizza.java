package DesignPattern.StructurePatterns.DecoratorPattern.Problem;

public class CheeseOlivePizza extends CheesePizza{

    @Override
    public String getDescription() {
        return super.getDescription()+" + Olive ";
    }

    @Override
    public double getCost() {
        return super.getCost()+5.0;
    }
}
