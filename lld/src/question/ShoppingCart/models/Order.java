package question.ShoppingCart.models;

import question.ShoppingCart.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    private  final String orderId;
    private final String userId;
    private final List<OrderItem> items;
    private final PriceSummary priceSummary;
    private OrderStatus status;
    private final LocalDateTime createdAt;

    public Order( String userId, List<OrderItem> items, PriceSummary priceSummary) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = items;
        this.priceSummary = priceSummary;
        status=OrderStatus.PENDING;
        createdAt=LocalDateTime.now();
    }

    public static Order from(Cart cart, PriceSummary priceSummary){
        List<OrderItem> orderItems=cart.getItems().stream()
                .map(ci->new OrderItem(
                        ci.getProduct().getId(),
                        ci.getProduct().getName(),
                        ci.getQuantity(),
                        ci.getProduct().getCost()
                )).toList();
        return new Order(cart.getUserId(),orderItems,priceSummary);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public PriceSummary getPriceSummary() {
        return priceSummary;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void orderConfirm(){
        this.status=OrderStatus.CONFIRMED;
    }
    public  void OrderFail(){
        this.status=OrderStatus.FAILED;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", total=" + priceSummary.getGrandTotal() +
                ", status=" + status +
                '}';
    }
}
