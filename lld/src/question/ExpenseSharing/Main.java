package question.ExpenseSharing;

import question.ExpenseSharing.model.ExpensesDetails;
import question.ExpenseSharing.model.Group;
import question.ExpenseSharing.model.User;
import question.ExpenseSharing.repo.GroupRepo;
import question.ExpenseSharing.repo.UserRepo;
import question.ExpenseSharing.service.GroupService;
import question.ExpenseSharing.service.SplitService;
import question.ExpenseSharing.service.UserService;
import question.ExpenseSharing.strategy.EqualShareStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepo userRepo=new UserRepo();
        UserService userService=new UserService(userRepo);
        GroupRepo groupRepo=new GroupRepo();
        GroupService groupService=new GroupService(groupRepo);
        userService.createUser("1","Anuj");
        userService.createUser("2","Ashis");
        userService.createUser("3","Vikash");
        userService.createUser("4","Vivek");
//        userService.createUser("5","Jack");
        List<User> members=List.of(userService.getUserById("1"),userService.getUserById("2"),userService.getUserById("3"),userService.getUserById("4"));
        Group manaliGroup=groupService.createGroup("group-1",userService.getUserById("1"),"Manali-Trip",members);
//        System.out.println(manaliGroup);

        manaliGroup.addExpensesDetailsList(new ExpensesDetails("expense-1",50.0,"Auto Fare",userService.getUserById("1")));
        manaliGroup.addExpensesDetailsList(new ExpensesDetails("expense-2",20.0,"Club Fee",userService.getUserById("2")));
        manaliGroup.addExpensesDetailsList(new ExpensesDetails("expense-3",100.0,"Dinner",userService.getUserById("3")));
        manaliGroup.addExpensesDetailsList(new ExpensesDetails("expense-4",30.0,"Break-fast",userService.getUserById("4")));
        System.out.println(manaliGroup);
        SplitService splitService=new SplitService();
        splitService.splitBill(manaliGroup,new EqualShareStrategy());

        System.out.println(manaliGroup.getExpenseShare());
//        System.out.println("================= Split Details ===================");
//        manaliGroup.getExpenseShare().stream().forEach(e-> {
//            System.out.println(");
//        });

    }
}
