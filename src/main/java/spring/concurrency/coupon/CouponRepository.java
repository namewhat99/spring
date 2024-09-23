package spring.concurrency.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.concurrency.annotation.Trace;
import spring.concurrency.entity.Coupon;


public interface CouponRepository extends JpaRepository<Coupon , Long> {

    Coupon findByCode(String code);
}
