package question.ShoppingCart.strategy.impl;

import question.ShoppingCart.models.Cart;
import question.ShoppingCart.strategy.ITaxStrategy;

import java.math.BigDecimal;

public class NoTaxStrategy implements ITaxStrategy {
    @Override
    public BigDecimal calculate(BigDecimal subtotal, Cart cart) {
        return BigDecimal.ZERO;
    }
}
