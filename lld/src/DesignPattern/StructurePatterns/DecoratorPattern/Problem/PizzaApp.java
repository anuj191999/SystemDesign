package DesignPattern.StructurePatterns.DecoratorPattern.Problem;

public class PizzaApp {
    public static void main(String[] args) {
        CheeseOlivePizza cheeseOlivePizza = new CheeseOlivePizza();
        System.out.println(cheeseOlivePizza.getDescription()+" "+cheeseOlivePizza.getCost());
    }
}
