package ExpenseSharing.strategy;

import ExpenseSharing.model.*;
import ExpenseSharing.service.UserService;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EqualShareStrategy implements SplitStrategy{

    private UserService userService;

    private static final Logger log = Logger.getLogger(EqualShareStrategy.class.getName());

    @Override
    public void splitBill(Group group) {

        log.info("EqualShareStrategy.splitBill() :: Starting bill split for GroupId="
                + group.getId()
                + ", TotalMembers=" + group.getMembers().size()
                + ", TotalExpenses=" + group.getExpensesDetailsList().size());

        int totalMembers = group.getMembers().size();

        double totalExpense = group.getExpensesDetailsList()
                .stream()
                .mapToDouble(ExpensesDetails::getAmount)
                .sum();

        log.info("EqualShareStrategy.splitBill() :: Total Expense=" + totalExpense);

        double perHeadShare = totalExpense / totalMembers;

        log.info("EqualShareStrategy.splitBill() :: Per Head Share=" + perHeadShare);

        Map<User, Double> paidAmountMap = group.getExpensesDetailsList()
                .stream()
                .collect(Collectors.groupingBy(
                        ExpensesDetails::getPaidBy,
                        Collectors.summingDouble(ExpensesDetails::getAmount)));

        log.info("EqualShareStrategy.splitBill() :: Paid Amount Map=" + paidAmountMap);

        List<User> debtors = new ArrayList<>();
        Map<User, Double> debtAmount = new HashMap<>();

        List<User> creditors = new ArrayList<>();
        Map<User, Double> creditAmount = new HashMap<>();

        Map<User, List<Settlement>> reports = new HashMap<>();

        for (User user : group.getMembers()) {

            double paid = paidAmountMap.getOrDefault(user, 0.0);
            double balance = paid - perHeadShare;

            log.info("EqualShareStrategy.splitBill() :: User="
                    + user.getId()
                    + ", Paid="
                    + paid
                    + ", Balance="
                    + balance);

            if (balance > 0) {
                creditors.add(user);
                creditAmount.put(user, balance);
            } else if (balance < 0) {
                debtors.add(user);
                debtAmount.put(user, -balance);
            }
        }

        log.info("EqualShareStrategy.splitBill() :: Creditors=" + creditors);
        log.info("EqualShareStrategy.splitBill() :: Credit Amount Map=" + creditAmount);

        log.info("EqualShareStrategy.splitBill() :: Debtors=" + debtors);
        log.info("EqualShareStrategy.splitBill() :: Debt Amount Map=" + debtAmount);

        List<Settlement> settlements = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < debtors.size() && j < creditors.size()) {

            User debtor = debtors.get(i);
            User creditor = creditors.get(j);

            double owe = debtAmount.get(debtor);
            double receive = creditAmount.get(creditor);

            double amount = Math.min(owe, receive);

            log.info("EqualShareStrategy.splitBill() :: Settlement -> Debtor="
                    + debtor.getId()
                    + ", Creditor="
                    + creditor.getId()
                    + ", Owe="
                    + owe
                    + ", Receive="
                    + receive
                    + ", Settled="
                    + amount);

            Settlement settlement = new Settlement(debtor, creditor, amount);
            settlements.add(settlement);

            debtAmount.put(debtor, owe - amount);
            creditAmount.put(creditor, receive - amount);

            log.info("EqualShareStrategy.splitBill() :: Remaining -> DebtorBalance="
                    + debtAmount.get(debtor)
                    + ", CreditorBalance="
                    + creditAmount.get(creditor));

            if (Math.abs(debtAmount.get(debtor)) < 1e-9)
                i++;

            if (Math.abs(creditAmount.get(creditor)) < 1e-9)
                j++;

            reports.computeIfAbsent(debtor, k -> new ArrayList<>()).add(settlement);
            reports.computeIfAbsent(creditor, k -> new ArrayList<>()).add(settlement);
        }

        log.info("EqualShareStrategy.splitBill() :: All Settlements=" + settlements);

        List<ExpenseShare> expenseShares = new ArrayList<>();

        for (User user : group.getMembers()) {

            List<Settlement> settlementListPerUser =
                    reports.getOrDefault(user, Collections.emptyList());

            double expendedAmount = paidAmountMap.getOrDefault(user, 0.0);

            double shareAmount = settlementListPerUser.stream()
                    .filter(e -> !e.getReceiver().getId().equals(user.getId()))
                    .mapToDouble(Settlement::getAmount)
                    .sum();

            log.info("EqualShareStrategy.splitBill() :: User="
                    + user.getId()
                    + ", Paid="
                    + expendedAmount
                    + ", ShareAmount="
                    + shareAmount
                    + ", SettlementCount="
                    + settlementListPerUser.size());

            expenseShares.add(new ExpenseShare(
                    user,
                    shareAmount,
                    expendedAmount,
                    perHeadShare,
                    settlementListPerUser));
        }

        log.info("EqualShareStrategy.splitBill() :: Final Expense Shares=" + expenseShares);

        group.seExpenseShare(expenseShares);

        log.info("EqualShareStrategy.splitBill() :: Bill split completed successfully.");
    }
}
