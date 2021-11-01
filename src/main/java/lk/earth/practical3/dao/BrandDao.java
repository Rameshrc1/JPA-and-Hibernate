package lk.earth.practical3.dao;

import lk.earth.practical3.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<Brand, Integer> {
}
