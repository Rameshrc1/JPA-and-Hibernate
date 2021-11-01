package lk.earth.practical3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Item> itemList;

    @JsonIgnore
    @ManyToMany(mappedBy = "categoryList")
    private List<Supplier> supplierList;

    public Category(Integer id) {
        this.id = id;
    }
}
