package libraryManagement.calculation;

import libraryManagement.book.BookItem;
import libraryManagement.member.Member;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class GenericCalculationStrategy implements CalculationStrategy{

    private final int maxBooks;
    private final int loanDays;
    private final double finePerDay;

    public GenericCalculationStrategy(int maxBooks, int loanDays, double finePerDay) {
        this.maxBooks = maxBooks;
        this.loanDays = loanDays;
        this.finePerDay = finePerDay;
    }

    @Override
    public boolean canBorrow(Member member) {
        return member.getBooksHeld().size() < maxBooks;
    }

    @Override
    public LocalDate calculateDueDate() {
        return LocalDate.now().plusDays(loanDays);
    }

    @Override
    public double calculateFine(Member member, BookItem item, LocalDate returnDate) {
        LocalDate dueDate = calculateDueDate();
        long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        return overdueDays > 0 ? overdueDays * finePerDay : 0;
    }

}
