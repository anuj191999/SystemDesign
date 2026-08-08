package question.ShoppingCart.repo;

import question.ShoppingCart.models.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository {
    Order save(Order order);
    Optional<Order> findById(String orderId);
    List<Order> findByUserId(String userId);
}
