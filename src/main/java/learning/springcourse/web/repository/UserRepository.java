package learning.springcourse.web.repository;

import learning.springcourse.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByUsername(String email);

}
