package coursework.computer.main.product;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor @Getter @Setter @ToString
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
    private Integer id;
    private String name;
    private String description;
    private float price;
    private String image;

    public Product(Integer id, String name, String description, float price, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }


}
