package DesignPattern.StructurePatterns.ProxyPattern.Solution;


public class Client {
    public static void main(String[] args) {
        Image img1=new ProxyImage("Red.jpg");
        Image img2=new ProxyImage("Green.jpg");
        //The image is loaded lazily when needed,
        // saving time and resources if the
        // image is never displayed.
//        img2.display();
//        img1.display();
    }
}
