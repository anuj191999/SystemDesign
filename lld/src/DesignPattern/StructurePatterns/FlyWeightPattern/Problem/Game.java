package DesignPattern.StructurePatterns.FlyWeightPattern.Problem;

public class Game {
    public static void main(String[] args) {
        // 5 red bullet Objects;

        for(int i=0;i<5;i++){
            Bullet bullet=new Bullet("red",i*10,i*13,5);
        }

        // 5 Green Bullet Objects;

        for(int i=0;i<5;i++){
            Bullet bullet=new Bullet("blue",i*10,i*13,5);
        }

        /**
         * Problem
         * Memory Overhead : Every Bullet stores Redundant data like color, Image
         * Performance : Slow Performance when many bullets are created
         * */
    }
}
