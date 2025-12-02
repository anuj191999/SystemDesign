package DesignPattern.StructurePatterns.ProxyPattern.Solution;


public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    public void loadFromDisk(){
        System.out.println("Loading Image from Disk "+fileName);
    }
}
