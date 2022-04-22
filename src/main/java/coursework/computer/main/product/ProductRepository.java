package coursework.computer.main.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//in the repo are a lot of handy queries ready for us to use.
//the repo directly gets,writes,deletes to the database/s
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //since the repository can only grab items based on their id
    //we need to make the query by ourselves for the functionality
    @Query("SELECT p FROM Product p WHERE p.name like ?1")
    Optional<Product> findByName(String productName);
}
