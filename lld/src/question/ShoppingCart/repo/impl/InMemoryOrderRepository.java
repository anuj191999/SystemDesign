package question.ShoppingCart.repo.impl;

import question.ShoppingCart.models.Order;
import question.ShoppingCart.repo.IOrderRepository;

import java.util.*;

public class InMemoryOrderRepository implements IOrderRepository
{
    private final Map<String,Order> byId=new HashMap<>();
    private final Map<String,List<Order>> userIndex=new HashMap<>();
    @Override
    public Order save(Order order) {
        byId.put(order.getOrderId(),order);
        userIndex.computeIfAbsent(order.getUserId(),k->new ArrayList<>()).add(order);
        return order;
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(byId.get(orderId));
    }

    @Override
    public List<Order> findByUserId(String userId) {
        return Collections.unmodifiableList(
                userIndex.getOrDefault(userId,Collections.emptyList())
        );
    }
}
