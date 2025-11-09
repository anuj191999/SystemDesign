package DesignPattern.BehaviouralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookCollectionv2 {

    List<Book> books;
    public BookCollectionv2() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public BookIterator createIterator() {
        return new BookIterator(books);
    }

    class BookIterator implements Iterator<Book> {
        private List<Book> books;
        private int index = 0;
        public BookIterator(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return index<books.size();
        }

        @Override
        public Book next() {
            return books.get(index++);
        }
    }
}
