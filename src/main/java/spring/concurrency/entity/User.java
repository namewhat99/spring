package spring.concurrency.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    @OneToMany(fetch = FetchType.LAZY)
    private ArrayList<Coupon> couponList;
}
