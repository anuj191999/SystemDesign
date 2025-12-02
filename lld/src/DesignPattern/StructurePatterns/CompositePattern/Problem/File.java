package DesignPattern.StructurePatterns.CompositePattern.Problem;

public class File {
    private String name;

    public File(String fileName) {
        this.name = fileName;
    }
    public void showDetails(){
        System.out.println("FileName: "+name);
    }
}
