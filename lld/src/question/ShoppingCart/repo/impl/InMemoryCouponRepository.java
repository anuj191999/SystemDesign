package question.ShoppingCart.repo.impl;

import question.ShoppingCart.models.Coupon;
import question.ShoppingCart.repo.ICouponRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCouponRepository implements ICouponRepository {

    private final Map<String,Coupon> store=new HashMap<>();
    @Override
    public Optional<Coupon> findByCode(String code) {
        return Optional.ofNullable(store.get(code));
    }

    @Override
    public Coupon save(Coupon coupon) {
        store.put(coupon.getCode(),coupon);
        return coupon;
    }
}
