package question.ShoppingCart.repo;

import question.ShoppingCart.models.Cart;

import java.util.Optional;

public interface ICartRepository {
    Optional<Cart> findByUserId(String  userId);
    Optional<Cart> findBySessionToken(String token);
    Cart save(Cart cart);
    void delete(String cardId);
}
