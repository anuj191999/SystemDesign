package question.ShoppingCart.strategy.impl;

import question.ShoppingCart.models.Cart;
import question.ShoppingCart.strategy.IShippingStrategy;

import java.math.BigDecimal;

public class FreeShippingStrategy implements IShippingStrategy {
    private final BigDecimal threshold;
    private final BigDecimal fallbackFee;

    public FreeShippingStrategy(BigDecimal threshold, BigDecimal fallbackFee) {
        this.threshold = threshold;
        this.fallbackFee = fallbackFee;
    }

    @Override
    public BigDecimal calculate(Cart cart) {
        return cart.getSubTotal().compareTo(threshold)>=0?BigDecimal.ZERO:fallbackFee;
    }
}
