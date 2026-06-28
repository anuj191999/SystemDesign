package ExpenseSharing.model;

import java.time.LocalDateTime;

public class ExpensesDetails {
    private String expenseId;
    private double amount;
    private String label;
    private LocalDateTime expendedAt;
    private User paidBy;

    public ExpensesDetails(String expenseId, double amount, String label, User paidBy) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.label = label;
        this.paidBy = paidBy;
        expendedAt=LocalDateTime.now();
    }

    public String getExpenseId() {
        return expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public String getLabel() {
        return label;
    }

    public User getPaidBy() {
        return paidBy;
    }

    @Override
    public String toString() {
        return "ExpensesDetails{" +
                "amount=" + amount +
                ", label='" + label + '\'' +
                ", paidBy=" + paidBy +
                '}';
    }
}
