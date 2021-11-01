package lk.earth.practical3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contact1;
    private String contact2;
    private String address;
    private String email;
    private String fax;

    @ManyToOne
    private Supplierstatus supplierstatus;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<Purchase> purchaseList;

    @ManyToMany
    @JoinTable(
            name = "suppliercategory",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categoryList;

    @ManyToMany
    @JoinTable(
            name = "supplierbrand",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private List<Brand> brandList;



    public Supplier(Integer id) {
        this.id = id;
    }

}
