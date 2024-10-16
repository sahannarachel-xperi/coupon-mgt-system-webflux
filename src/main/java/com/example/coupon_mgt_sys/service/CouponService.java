package com.example.coupon_mgt_sys.service;

import com.example.coupon_mgt_sys.entity.Coupon;
import com.example.coupon_mgt_sys.repository.CouponRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public Mono<String> storeCoupon(String couponCode, String expiryTime) {
        return couponRepository.findByCouponCode(couponCode)
                .flatMap(existingCoupon -> Mono.just("Coupon code already exists."))
                .switchIfEmpty(Mono.defer(() -> {
                    Coupon coupon = new Coupon();
                    coupon.setCouponCode(couponCode);
                    coupon.setExpiryTime(expiryTime);
                    return couponRepository.save(coupon)
                            .thenReturn("Coupon stored successfully.");
                }));
    }

    public Mono<String> claimCoupon(String deviceId) {
        return couponRepository.findAll()
                .filter(coupon -> deviceId.equals(coupon.getDeviceId()))
                .next()
                .flatMap(claimedCoupon -> Mono.just("This device has already claimed a coupon."))
                .switchIfEmpty(Mono.defer(() ->
                        couponRepository.findAll()
                                .filter(coupon -> coupon.getDeviceId() == null &&
                                        Instant.parse(coupon.getExpiryTime()).isAfter(Instant.now()))
                                .next()
                                .flatMap(availableCoupon -> {
                                    availableCoupon.setDeviceId(deviceId);
                                    return couponRepository.save(availableCoupon)
                                            .thenReturn(String.format("Coupon claimed successfully. Coupon code: %s, Expiry time: %s",
                                                    availableCoupon.getCouponCode(), availableCoupon.getExpiryTime()));
                                })
                                .switchIfEmpty(Mono.just("No available coupons to claim."))
                ));
    }

    public Mono<String> getCouponStatus(String couponCode) {
        return couponRepository.findByCouponCode(couponCode)
                .flatMap(coupon -> {
                    if (coupon.getDeviceId() != null) {
                        return Mono.just("Coupon has already been claimed.");
                    }
                    if (Instant.parse(coupon.getExpiryTime()).isBefore(Instant.now())) {
                        return Mono.just("Coupon has expired.");
                    }
                    return Mono.just("Coupon is available for claiming.");
                })
                .switchIfEmpty(Mono.just("Coupon does not exist."));
    }

    public Mono<String> getDeviceStatus(String deviceId) {
        return couponRepository.findAll()
                .filter(coupon -> deviceId.equals(coupon.getDeviceId()))
                .next()
                .map(coupon -> String.format("Device %s has claimed coupon %s. Expiry time: %s",
                        deviceId, coupon.getCouponCode(), coupon.getExpiryTime()))
                .defaultIfEmpty(String.format("Device %s has not claimed any coupon.", deviceId));
    }

    public Flux<CouponInfo> getAllCouponsInfo() {
        return couponRepository.findAll()  // Assuming this returns a Flux<Coupon>
                .map(this::convertToCouponInfo);
    }


    private CouponInfo convertToCouponInfo(Coupon coupon) {
        boolean isClaimed = coupon.getDeviceId() != null;
        boolean isExpired = Instant.parse(coupon.getExpiryTime()).isBefore(Instant.now());
        return new CouponInfo(
                coupon.getCouponCode(),
                coupon.getDeviceId(),
                isClaimed,
                isExpired,
                coupon.getExpiryTime()
        );
    }
    @Setter
    @Getter
    public static class CouponInfo {

        @Setter
        @Getter
        private String couponCode;
        private String deviceId;
        private boolean claimed;
        private boolean expired;
        private String expiryDate;

        // Constructor
        public CouponInfo(String couponCode, String deviceId, boolean claimed, boolean expired, String expiryDate) {
            this.couponCode = couponCode;
            this.deviceId = deviceId;
            this.claimed = claimed;
            this.expired = expired;
            this.expiryDate = expiryDate;
        }


    }
}