package question.ExpenseSharing.service;

import question.ExpenseSharing.model.Group;
import question.ExpenseSharing.strategy.SplitStrategy;

public class SplitService {

    public void splitBill(Group group, SplitStrategy splitStrategy){
        splitStrategy.splitBill(group);
    }
}
