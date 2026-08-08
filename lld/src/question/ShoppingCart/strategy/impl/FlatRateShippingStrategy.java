package question.ShoppingCart.strategy.impl;

import question.ShoppingCart.models.Cart;
import question.ShoppingCart.strategy.IShippingStrategy;

import java.math.BigDecimal;

public class FlatRateShippingStrategy implements IShippingStrategy {

    private static final BigDecimal FLAT_FEE=BigDecimal.valueOf(49);

    @Override
    public BigDecimal calculate(Cart cart) {
        return FLAT_FEE;
    }
}
