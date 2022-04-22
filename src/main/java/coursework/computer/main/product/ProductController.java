package coursework.computer.main.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//the productController, responsible for the endpoint mappins
//as seen below the main address for the products is: http(s)://localhost:(port number)/products
@RestController
/*@CrossOrigin*/
@RequestMapping(path = "products")
public class ProductController {

    //following business grade programming practises
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //the default address will return a json list of all the products(http(s)://localhost:(port number)/preoducts)
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    //grabbing a product details only by the productId
    @GetMapping(path = "/get/{productId}")
    public Product getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    //or getting one by its name. Normally this is not that good because maybe some products share the same name,
    //but in this case since we cant add or remove products I manually added unique names
    @GetMapping(path = "/get/byname/{productName}")
    public Product getProduct(@PathVariable String productName) {
        return productService.getProduct(productName);
    }
}
