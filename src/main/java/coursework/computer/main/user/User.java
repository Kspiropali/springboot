package coursework.computer.main.user;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Entity @Table(name = "_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Integer getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public User(String name, String email, LocalDate dob){
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}
