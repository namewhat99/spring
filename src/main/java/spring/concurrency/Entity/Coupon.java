package spring.concurrency.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;


@Entity
@Getter
public class Coupon {

    @Id
    @GeneratedValue
    private Long id;

}
