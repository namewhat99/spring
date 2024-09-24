package spring.concurrency.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import spring.concurrency.coupon.CouponService;

@Slf4j
@Import(LoggerAop.class)
@SpringBootTest
class LoggerAopTest {

    @Autowired
    private CouponService couponService;

    @Test
    public void loggingTest(){
        this.couponService.publishCoupon("123");
    }

}