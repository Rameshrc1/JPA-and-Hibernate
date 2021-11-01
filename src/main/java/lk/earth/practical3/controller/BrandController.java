package lk.earth.practical3.controller;

import lk.earth.practical3.dao.BrandDao;
import lk.earth.practical3.entity.Brand;
import lk.earth.practical3.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandDao brandDao;

    @GetMapping
    public List<Brand> getAll() {
        return brandDao.findAll();
    }
}

