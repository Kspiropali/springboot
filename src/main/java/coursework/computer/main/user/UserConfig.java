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
            User kristian = new User(
                    "Kristian",
                    "Spiropali",
                    "kristian",
                    "kris@kris.com",
                    LocalDate.of(2000, Month.JANUARY, 1)
            );

            repository.saveAll(List.of(kristian));
        };
    }
}
