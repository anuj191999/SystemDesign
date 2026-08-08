package question.ShoppingCart.strategy;

import question.ShoppingCart.models.Cart;

import java.math.BigDecimal;

public interface IShippingStrategy {
    BigDecimal calculate(Cart cart);
}
