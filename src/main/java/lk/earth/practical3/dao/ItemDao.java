package lk.earth.practical3.dao;

import lk.earth.practical3.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Integer> {
}
