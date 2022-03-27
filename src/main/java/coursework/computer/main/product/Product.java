package coursework.computer.main.product;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Entity @Table(name = "_product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "products_sequence",
            sequenceName = "products_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private LocalDate datePosted;
    private byte image;
    private float price;

    /*public Integer getAge(){
        return Period.between(datePosted, LocalDate.now()).getYears();
    }*/

    public Product(String name, String description, LocalDate datePosted){
        this.name = name;
        this.description = description;
        this.datePosted = datePosted;
    }
}
