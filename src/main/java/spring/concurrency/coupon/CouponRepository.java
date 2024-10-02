package spring.concurrency.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import spring.concurrency.annotation.Trace;
import spring.concurrency.entity.Coupon;


public interface CouponRepository extends JpaRepository<Coupon , Long> {

    Coupon findByCode(String code);

    @Modifying
    @Query(value = "INSERT INTO coupon (code) " +
            "SELECT :code " +
            "FROM DUAL " +
            "WHERE NOT EXISTS (" +
            "    SELECT 1 FROM coupon WHERE code = :code for update" +
            ") " +
            "AND (SELECT COUNT(*) FROM coupon) < 100",
            nativeQuery = true)
    void saveByConditions(String code);

}
