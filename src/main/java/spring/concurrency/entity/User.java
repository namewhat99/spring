package spring.concurrency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nickname;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Coupon> couponList;
}
