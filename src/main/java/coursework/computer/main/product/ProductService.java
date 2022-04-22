package coursework.computer.main.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    //linking the service with the repository
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //finds and returns all products in a json list
    public List<Product> getProducts(){
        System.out.println("Display all products request!");
        return productRepository.findAll();
    }

    //checking if the productId exists and returns in it a Json
    @Transactional
    public Product getProduct(Integer productId) {

        return productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(
                "Product with id " + productId + "does not exist"
        ));
    }


    //same thing with the above but checking the Name this time
    public Product getProduct(String productName) {
        return productRepository.findByName(productName).orElseThrow(() -> new IllegalStateException(
                "Product with Name: " + productName + "does not exist"
        ));
    }
}
