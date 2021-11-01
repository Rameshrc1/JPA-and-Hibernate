package lk.earth.practical3.controller;

import lk.earth.practical3.dao.ItemDao;
import lk.earth.practical3.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping
    public List<Item> getAll() {
        return itemDao.findAll();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable Integer id) {
        Optional<Item> optionalItem = itemDao.findById(id);
        if (optionalItem.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
            return optionalItem.get();
        }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!itemDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        itemDao.deleteById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item add(@RequestBody Item item) {return itemDao.save(item);}

    @PutMapping("/{id}")
    public Item update(@PathVariable Integer id, @RequestBody Item item) {
        if (!itemDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        item.setId(id);
        return itemDao.save(item);
    }
}














