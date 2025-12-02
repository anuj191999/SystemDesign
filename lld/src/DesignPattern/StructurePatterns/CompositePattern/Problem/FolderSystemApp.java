package DesignPattern.StructurePatterns.CompositePattern.Problem;

public class FolderSystemApp {
    public static void main(String[] args) {
        File file1=new File("File1.txt");
        File file2=new File("File2.txt");

        Folder folder=new Folder("Document");

        folder.addFile(file1);;
        folder.showDetails();
        System.out.println("++++++++++++++++++++++");
        folder.addFile(file2);
        folder.showDetails();
    }
}
