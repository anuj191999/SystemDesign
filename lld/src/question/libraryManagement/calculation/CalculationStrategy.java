package question.libraryManagement.calculation;

import question.libraryManagement.book.BookItem;
import question.libraryManagement.member.Member;

import java.time.LocalDate;

public interface CalculationStrategy {
    boolean canBorrow(Member member);
    LocalDate calculateDueDate();
    double calculateFine(Member member, BookItem bookItem,LocalDate returnData);
}
