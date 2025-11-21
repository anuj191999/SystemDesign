package DesignPattern.CreationalPatterns.FactoryPatterns.problem;

public class Bike implements Transport{
    @Override
    public void drive() {
        System.out.println("Bike drive");
    }
}
