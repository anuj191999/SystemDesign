package ECommerceOrderState;

public class Client {
    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();

        System.out.println("Order Workflow");
        orderContext.proceedToNext();
        orderContext.proceedToNext();
        orderContext.proceedToNext();
        orderContext.proceedToNext();
        orderContext.proceedToNext();
        orderContext.proceedToNext();
        orderContext.proceedToNext();
//        orderContext.cancelOrder();
    }
}
