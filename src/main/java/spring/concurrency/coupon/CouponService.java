package spring.concurrency.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    public void publishCoupon(){

    }
}
