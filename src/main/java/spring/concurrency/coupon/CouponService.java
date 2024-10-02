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
            String couponCode = publishCouponCode();
            this.couponRepository.saveByConditions(couponCode);
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
