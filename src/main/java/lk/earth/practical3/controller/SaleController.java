package lk.earth.practical3.controller;

import lk.earth.practical3.dao.SaleDao;
import lk.earth.practical3.entity.Sale;
import lk.earth.practical3.entity.Saleitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleDao saleDao;

    @GetMapping
    public List<Sale> getAll() {
        return saleDao.findAll();
    }

    @GetMapping("/{id}")
    public Sale get(@PathVariable Integer id) {
        Optional<Sale> optionalSale = saleDao.findById(id);
        if (optionalSale.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "sale not found");
            return optionalSale.get();
        }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!saleDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "sale not found");
        saleDao.deleteById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sale add(@RequestBody Sale sale) {

        for (Saleitem saleitem : sale.getSaleitemList()){
            saleitem.setSale(sale);
        }
        return saleDao.save(sale);
    }

    @PutMapping("/{id}")
    public Sale update(@PathVariable Integer id, @RequestBody Sale sale) {
        if (!saleDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "sale not found");

        sale.setId(id);

        for (Saleitem saleitem : sale.getSaleitemList()){
            saleitem.setSale(sale);
        }
        return saleDao.save(sale);
    }
}














