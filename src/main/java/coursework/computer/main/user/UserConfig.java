package coursework.computer.main.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    //automagically generating users. Can be more or less.
    //For convenience purposes
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

            User zxc = new User(
                    "test",
                    "test",
                    "kristian",
                    "test@t.t",
                    LocalDate.of(2000, Month.JANUARY, 1)
            );

            //saving them in the database. the repository class always takes a List of Objects<User>
            repository.saveAll(List.of(kristian, zxc));
        };
    }
}
