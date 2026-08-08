package question.ShoppingCart.models;

import java.math.BigDecimal;

public class PriceSummary {
    private final BigDecimal subtotal;
    private final BigDecimal couponDiscount;
    private final BigDecimal tax;
    private final BigDecimal shippingFree;
    private final BigDecimal platformFee;
    private final BigDecimal grandTotal;

    public PriceSummary(BigDecimal subtotal, BigDecimal couponDiscount, BigDecimal tax, BigDecimal shippingFree, BigDecimal platformFee) {
        this.subtotal = subtotal;
        this.couponDiscount = couponDiscount;
        this.tax = tax;
        this.shippingFree = shippingFree;
        this.platformFee = platformFee;
        this.grandTotal = subtotal
                .subtract(couponDiscount)
                .add(tax)
                .add(shippingFree)
                .add(platformFee)
                .add(BigDecimal.ZERO);
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getCouponDiscount() {
        return couponDiscount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getShippingFree() {
        return shippingFree;
    }

    public BigDecimal getPlatformFee() {
        return platformFee;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    @Override
    public String toString() {
        return "PriceSummary{" +
                "subtotal=" + subtotal +
                ", couponDiscount=" + couponDiscount +
                ", tax=" + tax +
                ", shippingFree=" + shippingFree +
                ", platformFee=" + platformFee +
                ", grandTotal=" + grandTotal +
                '}';
    }
}
