package lk.earth.practical3.controller;

import lk.earth.practical3.dao.SupplierDao;
import lk.earth.practical3.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierDao supplierDao;

    @GetMapping
    public List<Supplier> getAll() {
        return supplierDao.findAll();
    }

    @GetMapping("/{id}")
    public Supplier get(@PathVariable Integer id) {
        Optional<Supplier> optionalSupplier = supplierDao.findById(id);
        if (optionalSupplier.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "supplier not found");
            return optionalSupplier.get();
        }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!supplierDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "supplier not found");
        supplierDao.deleteById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier add(@RequestBody Supplier supplier) {return supplierDao.save(supplier);}

    @PutMapping("/{id}")
    public Supplier update(@PathVariable Integer id, @RequestBody Supplier supplier) {
        if (!supplierDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "supplier not found");

        supplier.setId(id);
        return supplierDao.save(supplier);
    }
}














