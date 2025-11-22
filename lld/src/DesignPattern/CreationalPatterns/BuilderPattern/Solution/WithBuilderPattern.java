package DesignPattern.CreationalPatterns.BuilderPattern.Solution;


public class WithBuilderPattern {
    public static void main(String[] args) {
        House house=new House.HouseBuilder("Anuj_House","Medium","RED").build();
        System.out.println(house);
    }
}
