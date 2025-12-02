package DesignPattern.StructurePatterns.DecoratorPattern.Problem;

public class CheesePizza extends BasicPizza{


    @Override
    public String getDescription() {
        return super.getDescription()+"+ Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost()+5.0;
    }
}
