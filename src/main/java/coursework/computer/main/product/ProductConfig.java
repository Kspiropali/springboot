package coursework.computer.main.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner1(ProductRepository repository){


        return args -> {
            List<Product> products = Arrays.asList(
            new Product("Alieware Laptop 5", "Very good laptop for everyone", 1299, "laptop1.jpg"),
            new Product("Dell Xps 13", "Compact and high-grade material", 2199, "laptop2.jpg"),
            new Product("Lenovo Legion Y5", "Best gaming laptop out there!", 999, "laptop3.jpg"),
            new Product("Dell Inspiron 5", "Very fast laptop", 699, "laptop4.jpg"),
            new Product("TurboX Infinite 6S", "Turbo fast laptop for everyone", 1999, "laptop5.jpg"),
            new Product("Basic Laptop 4", "Basic laptop for kids to learn", 369, "laptop6.jpg"),
            new Product("Acer Predator 3000", "Great laptop with 4k", 1399, "pc1.jpg"),
            new Product("Apple iMac 2020", "Best computer ", 899, "pc2.jpg"),
            new Product("AlienWare Aurora R10", "amazing price laptop!", 1199, "pc3.jpg"),
            new Product("MSI MEG Trident 4", "amazing price laptop!", 499, "motherboard1.jpg"),
            new Product("Microsoft Surface Pro", "amazing price laptop!", 699, "pc4.jpg"),
            new Product("Acer Super X", "amazing price laptop!", 999,"pc5.jpg")
            );
            repository.saveAll(products);
        };
    }
}
