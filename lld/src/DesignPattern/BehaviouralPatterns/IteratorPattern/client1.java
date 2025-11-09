package DesignPattern.BehaviouralPatterns.IteratorPattern;

public class client1 {
    public static void main(String[] args) {
        BookCollectionV1 collection = new BookCollectionV1();
        collection.addBook(new Book("C++ Book"));
        collection.addBook(new Book("Java Programming"));
        collection.addBook(new Book("Python Programming"));
        collection.addBook(new Book("PHP Programming"));
        collection.addBook(new Book("JavaScript"));

        for(int i=0;i<collection.getBooks().size();i++){
            System.out.println(collection.getBooks().get(i));
        }
    }
}
