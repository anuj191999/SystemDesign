package question.ShoppingCart.strategy;

import question.ShoppingCart.models.Cart;

import java.math.BigDecimal;

public interface ITaxStrategy {
    BigDecimal calculate(BigDecimal subtotal, Cart cart);
}
