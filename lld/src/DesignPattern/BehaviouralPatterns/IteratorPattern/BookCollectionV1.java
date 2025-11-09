package DesignPattern.BehaviouralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class BookCollectionV1 {
    private List<Book> books;

    public BookCollectionV1() {
        this.books=new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks(){
        return books;
    }
}
