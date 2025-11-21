package DesignPattern.CreationalPatterns.FactoryPatterns.solution;


public class Car implements Transport {

    @Override
    public void drive() {
        System.out.println("Car driving");
    }
}
