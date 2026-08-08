package question.ShoppingCart.repo;

import question.ShoppingCart.models.Coupon;

import java.util.Optional;

public interface ICouponRepository {
    Optional<Coupon> findByCode(String code);
    Coupon save(Coupon coupon);
}
