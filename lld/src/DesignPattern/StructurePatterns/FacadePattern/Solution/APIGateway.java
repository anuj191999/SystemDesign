package DesignPattern.StructurePatterns.FacadePattern.Solution;

public class APIGateway {
    private UserService userService;
    private PaymentService paymentService;
    private OrderService orderService;


    public APIGateway() {
        this.userService = new UserService();
        this.paymentService = new PaymentService();
        this.orderService = new OrderService();
    }

    public String getFullOrderDetails(String userId,String orderId,String paymentId){
        String userDetails = userService.getUserDetails(userId);
        String orderDetails = orderService.getOrderDetails(orderId);
        String paymentProcessing = paymentService.processPayment(paymentId);

        return userDetails + "\n" + orderDetails + "\n" + paymentProcessing;
    }
}
