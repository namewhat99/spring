package spring.concurrency.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.concurrency.annotation.Trace;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @Trace
    @GetMapping
    public void getCoupon(@RequestParam String nickname){
        this.couponService.publishCoupon(nickname);
    }
}
