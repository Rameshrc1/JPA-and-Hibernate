package lk.earth.practical3.dao;

import lk.earth.practical3.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<Supplier, Integer> {
}
