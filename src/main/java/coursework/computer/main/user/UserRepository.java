package coursework.computer.main.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    //implementation of findUserByEmail, since it does not exist in the class repository by default.
    //since the email is unique it can only return 1 or none at a request
    @Query("SELECT s FROM User s WHERE s.email= ?1")
    Optional<User> findUserByEmail(String email);


}
