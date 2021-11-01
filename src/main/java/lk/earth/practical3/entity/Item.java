package lk.earth.practical3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private byte[] photo;
    private Integer qty;
    private Integer rop;
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Purchaseitem> purchaseitemList;

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Saleitem> saleitemList;

    public Item(Integer id) {
        this.id = id;
    }
}
