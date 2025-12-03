package DesignPattern.StructurePatterns.FlyWeightPattern.Solution;

public class BulletType {
    private String color; // Intrinsic property

    public BulletType(String color) {
        this.color = color;
        System.out.println("Creating BulletType With color "+color);
    }

    @Override
    public String toString() {
        return "BulletType{" +
                "color='" + color + '\'' +
                '}';
    }
}
