package DesignPattern.BehaviouralPatterns.IteratorPattern;

import java.util.Iterator;

public class Client3 {
    public static void main(String[] args) {
        BookCollectionV3 collection=new BookCollectionV3();

        collection.addBook(new Book("C++ Programming"));
        collection.addBook(new Book("Java Programming"));
        collection.addBook(new Book("Python Programming"));
        collection.addBook(new Book("PHP Programming"));
        collection.addBook(new Book("JavaScript"));

        Iterator<Book> it = collection.iterator();

        while (it.hasNext()){
            Book book=it.next();
            System.out.println(book);
        }
    }
}
