package coursework.computer.main.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*@Query("SELECT s FROM _user s WHERE s.email= ?1")
    Optional<User> findUserByEmail(String email);*/
}
