package DesignPattern.CreationalPatterns.FactoryPatterns.problem;

public class Car implements Transport{

    @Override
    public void drive() {
        System.out.println("Car driving");
    }
}
