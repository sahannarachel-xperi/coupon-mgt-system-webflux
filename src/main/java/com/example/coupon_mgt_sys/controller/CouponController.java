package com.example.coupon_mgt_sys.controller;

import com.example.coupon_mgt_sys.entity.Coupon;
import com.example.coupon_mgt_sys.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public Mono<String> storeCoupon(@RequestBody Coupon coupon) {
        return couponService.storeCoupon(coupon.getCouponCode(), coupon.getExpiryTime());
    }

    @GetMapping("/claim")
    public Mono<String> claimCoupon(@RequestBody ClaimRequest request) {
        return couponService.claimCoupon(request.getDeviceId());
    }

    @GetMapping("/{couponCode}/status")
    public Mono<String> getCouponStatus(@PathVariable String couponCode) {
        return couponService.getCouponStatus(couponCode);
    }

    @GetMapping("/device/{deviceId}/status")
    public Mono<String> getDeviceStatus(@PathVariable String deviceId) {
        return couponService.getDeviceStatus(deviceId);
    }

    @GetMapping("/all")
    public Flux<CouponService.CouponInfo> getAllCouponsInfo() {
        return couponService.getAllCouponsInfo();
    }

    static class ClaimRequest {
        private String deviceId;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }
    }
}