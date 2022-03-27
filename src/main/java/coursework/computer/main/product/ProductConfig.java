package coursework.computer.main.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ProductConfig {

    /*@Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product mariam = new Product(
                    "Maria",
                    "mariam.asd.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Product john = new Product(
                    "John",
                    "john.asd.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );


            repository.saveAll(List.of(mariam, john));
        };
    }*/
}
