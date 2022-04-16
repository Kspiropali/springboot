package coursework.computer.main.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "/get/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping(path = "/get/byname/{productName}")
    public Product getProduct(@PathVariable String productName) {
        return productService.getProduct(productName);
    }

    /*@PostMapping(path = "/register")
    public void addNewProduct(@RequestBody Product product){
        System.out.println(product.toString());
        productService.addNewProduct(product);
    }*/

    /*@DeleteMapping(path = "/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }
*/
   /* @PutMapping(path = "/update/{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {
        productService.updateProduct(productId, name, description);
    }*/
}
