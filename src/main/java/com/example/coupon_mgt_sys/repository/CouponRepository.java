package com.example.coupon_mgt_sys.repository;

import com.example.coupon_mgt_sys.entity.Coupon;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CouponRepository {
    Mono<Coupon> findByCouponCode(String couponCode);
    Flux<Coupon> findAll();
    Mono<Coupon> save(Coupon coupon);
}