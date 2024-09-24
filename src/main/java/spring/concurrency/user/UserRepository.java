package spring.concurrency.user;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.concurrency.entity.User;

public interface UserRepository extends JpaRepository<User , Long> {

    User findByNickname(String nickname);
}
