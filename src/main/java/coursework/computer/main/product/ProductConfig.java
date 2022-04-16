package coursework.computer.main.product;

import coursework.computer.main.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner1(ProductRepository repository){


        return args -> {
            List<Product> products = Arrays.asList(
            new Product("Alieware Laptop 5", "Very good laptop for everyone", 1299, "/home/kspir/project/main/src/main/resources/images/post1.jpg"),
            new Product("Dell Xps 13", "Compact and high-grade material", 2199, "/home/kspir/project/main/src/main/resources/images/post2.jpg"),
            new Product("Lenovo Legion Y5", "Best gaming laptop out there!", 999, "../scripts/post3.jpg"),
            new Product("Dell Inspiron 5", "Very fast laptop", 699, "../scripts/post4.jpg"),
            new Product("TurboX Infinite 6S", "Turbo fast laptop for everyone", 1999, "picture"),
            new Product("Basic Laptop 4", "Basic laptop for kids to learn", 369, "picture"),
            new Product("Acer Predator 3000", "Great laptop with 4k", 1399, "picture"),
            new Product("Apple iMac 2020", "Best computer ", 899, "picture"),
            new Product("AlienWare Aurora R10", "amazing price laptop!", 1199, "picture"),
            new Product("MSI MEG Trident 4", "amazing price laptop!", 499, "picture"),
            new Product("Microsoft Surface Pro", "amazing price laptop!", 699, "picture"),
            new Product("Acer Super X", "amazing price laptop!", 999,"picture")
            );
            repository.saveAll(products);
        };
    }
}
