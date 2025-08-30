package libraryManagement.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookItem {
    private static List<String> allocatedBarCode=new ArrayList<>();
    private String barcode;
    private Book book; // Reference to the parent Book
    private BookStatus bookStatus;
    private String rackNo;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private String borrowedByMemberId; // Track who borrowed this item

    public BookItem(String barcode, Book book, BookStatus bookStatus, String rackNo) {
        if (barcode == null || barcode.trim().isEmpty() || allocatedBarCode.contains(barcode)) {
            throw new IllegalArgumentException("Barcode cannot be null or empty");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (rackNo == null || rackNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Rack number cannot be null or empty");
        }
        
        this.barcode = barcode.trim();
        this.book = book;
        this.bookStatus = bookStatus;
        this.rackNo = rackNo.trim();
        allocatedBarCode.add(barcode);
    }

    // Constructor for backward compatibility
    public BookItem(String barcode, BookStatus bookStatus, String rackNo) {
        this(barcode, null, bookStatus, rackNo);
    }

    public String getBarcode() {
        return barcode;
    }

    public Book getBook() {
        return book;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        if (rackNo == null || rackNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Rack number cannot be null or empty");
        }
        this.rackNo = rackNo.trim();
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getBorrowedByMemberId() {
        return borrowedByMemberId;
    }

    public void setBorrowedByMemberId(String borrowedByMemberId) {
        this.borrowedByMemberId = borrowedByMemberId;
    }

    public boolean isOverdue() {
        return dueDate != null && LocalDate.now().isAfter(dueDate);
    }

    public int getDaysOverdue() {
        if (dueDate == null || !isOverdue()) {
            return 0;
        }
        return (int) (LocalDate.now().toEpochDay() - dueDate.toEpochDay());
    }

    public boolean isAvailable() {
        return bookStatus == BookStatus.AVAILABLE;
    }

    public boolean isBorrowed() {
        return bookStatus == BookStatus.BORROWED;
    }

    public boolean isReserved() {
        return bookStatus == BookStatus.RESERVED;
    }

    public boolean isLost() {
        return bookStatus == BookStatus.LOST;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookItem bookItem = (BookItem) o;
        return Objects.equals(barcode, bookItem.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "barcode='" + barcode + '\'' +
                ", book=" + (book != null ? book.getTitle() : "null") +
                ", bookStatus=" + bookStatus +
                ", rackNo='" + rackNo + '\'' +
                ", borrowedDate=" + borrowedDate +
                ", dueDate=" + dueDate +
                ", borrowedByMemberId='" + borrowedByMemberId + '\'' +
                '}';
    }
}
