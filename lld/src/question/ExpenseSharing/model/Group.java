package question.ExpenseSharing.model;


import java.util.*;

public class Group {
    private String id;
    private String groupName;
    private List<ExpensesDetails> expensesDetailsList;
    List<User> members;
    private User createdBy;
    List<ExpenseShare> expenseShare;

    public Group(String id, String groupName, List<User> members,User createdBy) {
        this.id = id;
        this.groupName = groupName;
        this.members=members;
        this.expensesDetailsList=new ArrayList<>();
        this.createdBy=createdBy;
        expenseShare=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getMembers() {
        return members;
    }

    public void addMembers(User member) {
        this.members.add(member);
    }

    public List<ExpensesDetails> getExpensesDetailsList() {
        return expensesDetailsList;
    }

    public void addExpensesDetailsList(ExpensesDetails expensesDetail) {
        this.expensesDetailsList.add(expensesDetail);
    }

    public List<ExpenseShare> getExpenseShare() {
        return expenseShare;
    }

    public void seExpenseShare(List<ExpenseShare> expenseShare) {
        this.expenseShare = expenseShare;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", expensesDetailsList=" + expensesDetailsList +
                ", members=" + members +
                ", expenseShare=" + expenseShare +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;

        Group other = (Group) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
