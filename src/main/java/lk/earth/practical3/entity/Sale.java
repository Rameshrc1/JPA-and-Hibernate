package lk.earth.practical3.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    private BigDecimal total;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Saleitem> saleitemList;

    public Sale(Integer id) {
        this.id = id;
    }
}
