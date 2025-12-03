package DesignPattern.StructurePatterns.FlyWeightPattern.Solution;

public class Bullet {
    private BulletType bulletType;
    private int x,y;
    private double velocity;

    public Bullet(String color, int x, int y, double velocity) {
        this.bulletType = BulletTypeFactory.getBulletType(color);
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Created Bullet at (" + x + ", " + y + ") with velocity " + velocity+"Bullet Type: " + bulletType);
    }

    public void display(){
        System.out.println("Bullet at (" + x + ", " + y + ") moving at velocity " + velocity);
    }
}
