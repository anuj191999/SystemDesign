package question.ShoppingCart.strategy.impl;

import question.ShoppingCart.models.Cart;
import question.ShoppingCart.strategy.ITaxStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GstTaxStrategy implements ITaxStrategy {
    private static final BigDecimal GST_RATE=BigDecimal.valueOf(0.18);

    @Override
    public BigDecimal calculate(BigDecimal subtotal, Cart cart) {
        return subtotal.multiply(GST_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
