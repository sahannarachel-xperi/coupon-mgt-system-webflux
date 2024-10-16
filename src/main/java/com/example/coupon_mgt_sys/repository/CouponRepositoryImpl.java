package com.example.coupon_mgt_sys.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.coupon_mgt_sys.entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public Mono<Coupon> findByCouponCode(String couponCode) {
        return Mono.fromCallable(() -> dynamoDBMapper.load(Coupon.class, couponCode));
    }

    @Override
    public Flux<Coupon> findAll() {
        return Flux.fromIterable(dynamoDBMapper.scan(Coupon.class, new DynamoDBScanExpression()));
    }

    @Override
    public Mono<Coupon> save(Coupon coupon) {
        return Mono.fromCallable(() -> {
            dynamoDBMapper.save(coupon);
            return coupon;
        });
    }
}