package coursework.computer.main.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner1(ProductRepository repository){
        return args -> {


            Product test1 = new Product("alieware laptop", "amazing price laptop!", 300, LocalDate.of(2000, Month.JANUARY, 5), "picture");
            System.out.println("Working Directory = " + System.getProperty("user.dir"));

            repository.saveAll(List.of(test1));
        };
    }
}
