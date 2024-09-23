package spring.concurrency.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.concurrency.annotation.Trace;


@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Trace
    public void publishCoupon(){
        return;
    }
}
