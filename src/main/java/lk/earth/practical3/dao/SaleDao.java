package lk.earth.practical3.dao;

import lk.earth.practical3.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDao extends JpaRepository<Sale, Integer> {
}
