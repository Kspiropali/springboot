package coursework.computer.main.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User mariam = new User(
                    "Maria",
                    "mariam.asd.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            User john = new User(
                    "John",
                    "john.asd.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );


            repository.saveAll(List.of(mariam, john));
        };
    }
}
