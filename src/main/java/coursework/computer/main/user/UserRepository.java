package coursework.computer.main.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*@Query("SELECT s FROM _user s WHERE s.email= ?1")
    Optional<User> findUserByEmail(String email);*/
}
