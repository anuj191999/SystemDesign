package DesignPattern.StructurePatterns.FlyWeightPattern.Solution;


public class Game {
    public static void main(String[] args) {

        // 5 red bullet object;

        for(int i=0;i<5;i++){
            Bullet bullet=new Bullet("Red",i*10,i*12,5.0);
        }

        // 5 Blue bullet object;

        for(int i=0;i<5;i++){
            Bullet bullet=new Bullet("Blue",i*9,i*13,5.7);
        }
    }
}
