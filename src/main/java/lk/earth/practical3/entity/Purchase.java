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
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private LocalDateTime date;
    private BigDecimal total;


    @ManyToOne
    private Supplier supplier;

    @OneToMany (mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchaseitem> purchaseitemList;

    public Purchase(Integer id) {
        this.id = id;
    }
}
