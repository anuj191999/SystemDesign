package question.ShoppingCart.models;

import question.ShoppingCart.enums.DiscountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Coupon {
    private final String couponId;
    private final String code;
    private final DiscountType discountType;
    private final LocalDateTime expiryDate;
    private final BigDecimal discountValue;
    private boolean isActive;

    public Coupon(String couponId, String code, DiscountType discountType, LocalDateTime expiryDate,BigDecimal discountValue) {
        this.couponId = couponId;
        this.code = code;
        this.discountType = discountType;
        this.expiryDate = expiryDate;
        this.discountValue=discountValue;
        this.isActive = true;
    }

    public boolean isValid(){
        return isActive && LocalDateTime.now().isBefore(expiryDate);
    }

    public BigDecimal apply(BigDecimal subtotal){
        if(!isValid()){
            return BigDecimal.ZERO;
        }
        if(discountType==DiscountType.PERCENTAGE){
            return subtotal.multiply(discountValue).divide(BigDecimal.valueOf(100));
        }
        return discountValue.min(subtotal);
    }

    public String getCouponId() {
        return couponId;
    }

    public String getCode() {
        return code;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }
    public boolean isActive(){
        return isActive;
    }

    public void deactivate(){
        this.isActive=false;
    }
}
