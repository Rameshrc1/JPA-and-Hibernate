package lk.earth.practical3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor

public class Saleitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer qty;
    private BigDecimal unitprice;

    @ManyToOne
    private Item item;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    public Saleitem(Integer id) {
        this.id = id;
    }
}
