package coursework.computer.main.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//main user model which is used by the controller
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Entity @Table(name = "_user")
public class User {
    //Automagically setting the UNIQUE ID of our table _users in our database
    //the table users exists and thus name name _user
    @Id
    //generating the main sequence incrementally. Everytime a user is added the id will be
    //based on the current_sequence+1
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    //getting and setting the sequence to the userId
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private Long id;
    private String name;
    private String password;
    private String surname;
    private String email;
    private LocalDate dob;

    public User(String name, String surname, String password, String email, LocalDate dob){
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }
}
