package lk.earth.practical3.dao;

import lk.earth.practical3.entity.Saleitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleitemDao extends JpaRepository<Saleitem, Integer> {
}
