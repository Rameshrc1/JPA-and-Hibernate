package lk.earth.practical3.dao;

import lk.earth.practical3.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {
}
