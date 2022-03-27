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

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
       /* Optional<Product> ProductOptional = ProductRepository.findProductByEmail(Product.getEmail());
        if(ProductOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }*/

        //product.setProductDatePosted(LocalDate.of(2020, Month.APRIL, 5));
        productRepository.save(product);

    }

    public void deleteProduct(Long ProductId) {
        boolean exists = productRepository.existsById(ProductId);
        if(!exists){
            throw new IllegalStateException("Product with id "+ ProductId + "does not exist");
        }

        productRepository.deleteById(ProductId);
    }

    @Transactional
    public void updateProduct(Long productId, String name, String description) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(
                "product with id " + productId + "does not exist"
        ));

        if(name != null &&
                name.length()>0 &&
                !Objects.equals(product.getName(), name)){
            product.setName(name);
        }

        if(description != null &&
                description.length()>0 &&
                !Objects.equals(product.getDescription(), description)){
            product.setDescription(description);
        }
    }

    @Transactional
    public Product getProduct(Long productId) {

        return productRepository.findById(productId).orElseThrow(() -> new IllegalStateException(
                "Product with id " + productId + "does not exist"
        ));
    }
}
