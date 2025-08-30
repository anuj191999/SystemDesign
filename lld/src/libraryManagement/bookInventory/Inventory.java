package libraryManagement.bookInventory;


import libraryManagement.book.BookItem;
import libraryManagement.book.BookStatus;
import libraryManagement.member.Member;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, BookItem> bookList;
    public Inventory() {
        bookList = new HashMap<>();
    }
    public void addCopies(BookItem bookItem) {
        String barCode=bookItem.getBarcode();
        if(bookList.containsKey(barCode)) {
            throw new IllegalArgumentException("Duplicate bar code");
        }
        bookList.put(barCode, bookItem);
    }

    public BookItem borrow(String barCode) {
        BookItem bookItem = bookList.get(barCode);

        if(bookItem.getBookStatus()== BookStatus.AVAILABLE) {
            bookItem.setBookStatus(BookStatus.BORROWED);
        }
        return bookItem;
    }
    public BookItem returnBook(String barCode,Member member) {
        BookItem bookItem = bookList.get(barCode);
        if(bookItem.getBookStatus()== BookStatus.BORROWED) {
            bookItem.setBookStatus(BookStatus.AVAILABLE);
        }
        return bookItem;
    }
    public BookItem markLost(String barCode,Member member) {
        BookItem bookItem = bookList.get(barCode);
        if(bookItem.getBookStatus()== BookStatus.BORROWED) {
            bookItem.setBookStatus(BookStatus.LOST);
        }
        return bookItem;
    }

    public Collection<BookItem> getBookList() {
        return bookList.values();
    }

}
