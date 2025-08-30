package libraryManagement;

import libraryManagement.book.BookItem;
import libraryManagement.bookInventory.Inventory;
import libraryManagement.calculation.CalculationFactory;
import libraryManagement.calculation.CalculationStrategy;
import libraryManagement.member.Member;

import java.time.LocalDate;
import java.util.List;

public class LibraryManager {

    private Inventory inventory;

    public LibraryManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<BookItem> getALlBooks(){
        return (List<BookItem>) this.inventory.getBookList();
    }

    public BookItem borrowBook(String barCode, Member member){
        CalculationStrategy calculationStrategy= CalculationFactory.getCalculationStrategy(member.getRole());
        if(calculationStrategy.canBorrow(member)){
            BookItem bookItem=inventory.borrow(barCode);
            bookItem.setBorrowedByMemberId(member.getMemberId());
            bookItem.setBorrowedDate(LocalDate.now());
            bookItem.setDueDate(calculationStrategy.calculateDueDate());
            return bookItem;
        }
        else{
            System.out.println("You Can't Borrow this book");
        }
        return null;
    }

}
