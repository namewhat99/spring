package spring.concurrency.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Coupon> couponList;
}
