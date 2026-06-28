package ExpenseSharing.service;

import ExpenseSharing.model.Group;
import ExpenseSharing.strategy.SplitStrategy;

public class SplitService {

    public void splitBill(Group group, SplitStrategy splitStrategy){
        splitStrategy.splitBill(group);
    }
}
