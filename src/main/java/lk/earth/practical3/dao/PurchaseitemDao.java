package lk.earth.practical3.dao;

import lk.earth.practical3.entity.Purchaseitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseitemDao extends JpaRepository<Purchaseitem, Integer> {
}
