package ExpenseSharing.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExpenseShare {
    private String id;
    private User user;
    private List<Settlement> settlementList;
    private double shareAmount;
    private double expendedAmount;
    private LocalDateTime createdAt;
    private double perHeadShare;

    public ExpenseShare(User user,double shareAmount, double expendedAmount,double perHeadShare,List<Settlement> settlementList) {
        this.user=user;
        this.shareAmount = shareAmount;
        this.expendedAmount = expendedAmount;
        this.perHeadShare=perHeadShare;
        id= UUID.randomUUID().toString();
        createdAt=LocalDateTime.now();
        this.settlementList=settlementList;
    }

    public String getId() {
        return id;
    }

    public double getShareAmount() {
        return shareAmount;
    }

    public double getExpendedAmount() {
        return expendedAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Settlement> getSettlementList() {
        return settlementList;
    }

    public void setSettlementList(List<Settlement> settlementList) {
        this.settlementList = settlementList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ExpenseShare{" +
                "user=" + user.getName() +
                ", settlementList=" + settlementList +
                ", shareAmount=" + shareAmount +
                ", expendedAmount=" + expendedAmount +
                ", perHeadShare=" + perHeadShare +
                '}';
    }
}
