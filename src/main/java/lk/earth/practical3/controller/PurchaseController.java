package lk.earth.practical3.controller;

import lk.earth.practical3.dao.PurchaseDao;
import lk.earth.practical3.entity.Purchase;
import lk.earth.practical3.entity.Purchaseitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseDao purchaseDao;

    @GetMapping
    public List<Purchase> getAll() {
        return purchaseDao.findAll();
    }

    @GetMapping("/{id}")
    public Purchase get(@PathVariable Integer id) {
        Optional<Purchase> optionalPurchase = purchaseDao.findById(id);
        if (optionalPurchase.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "purchase not found");
            return optionalPurchase.get();
        }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!purchaseDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "purchase not found");
        purchaseDao.deleteById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase add(@RequestBody Purchase purchase) {

        for (Purchaseitem purchaseitem : purchase.getPurchaseitemList()){
            purchaseitem.setPurchase(purchase);
        }
        return purchaseDao.save(purchase);
    }

    @PutMapping("/{id}")
    public Purchase update(@PathVariable Integer id, @RequestBody Purchase purchase) {
        if (!purchaseDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "purchase not found");

        purchase.setId(id);

        for (Purchaseitem purchaseitem : purchase.getPurchaseitemList()){
            purchaseitem.setPurchase(purchase);
        }
        return purchaseDao.save(purchase);
    }
}














