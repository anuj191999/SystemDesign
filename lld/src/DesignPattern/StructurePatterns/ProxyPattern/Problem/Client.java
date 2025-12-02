package DesignPattern.StructurePatterns.ProxyPattern.Problem;

public class Client {
    public static void main(String[] args) {
        Image img1=new RealImage("Red.jpg");
        Image img2=new RealImage("Green.jpg");
        //Here, the RealImage is loaded every time we create it,
        // which can be inefficient if the image is not always required.
//        img2.display();
//        img1.display();
    }
}
