package lk.earth.practical3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String contact1;
    private String contact2;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Sale> saleList;

    public Customer(Integer id) {
        this.id = id;
    }
}
