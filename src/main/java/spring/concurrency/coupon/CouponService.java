package spring.concurrency.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.concurrency.annotation.Retry;
import spring.concurrency.annotation.Trace;
import spring.concurrency.entity.Coupon;
import spring.concurrency.entity.User;
import spring.concurrency.user.UserRepository;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    private final UserRepository userRepository;

    @Trace
    @Transactional
    public void publishCoupon(String nickname){

        User user = isMember(nickname);

        if(user != null){

            long couponCount = this.couponRepository.count();

            if(couponCount < 100L){

                String couponCode = this.publishCouponCode();

                Coupon isCouponExists = this.couponRepository.findByCode(couponCode);

                if(isCouponExists == null){

                    Coupon coupon = Coupon.builder().code(couponCode).user(user).build();
                    this.couponRepository.save(coupon);

                }else{
                    throw new IllegalStateException("중복된 쿠폰 번호입니다");
                }
            }
            else{
                throw new IllegalArgumentException("늦었습니다");
            }
        }else {
            throw new IllegalArgumentException("없는 유저입니다");
        }
    }

    private String publishCouponCode(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private User isMember(String nickname){
        return this.userRepository.findByNickname(nickname);
    }
}
