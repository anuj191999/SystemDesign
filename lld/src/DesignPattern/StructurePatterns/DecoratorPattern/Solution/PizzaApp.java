package DesignPattern.StructurePatterns.DecoratorPattern.Solution;

import org.w3c.dom.ls.LSOutput;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza pizza=new MushroomDecorator(new CheeseDecorator(new BasicPizza()));
        System.out.println(pizza.getDescription());
//        System.out.println("================");
        System.out.println(pizza.getPrice());
    }
}
