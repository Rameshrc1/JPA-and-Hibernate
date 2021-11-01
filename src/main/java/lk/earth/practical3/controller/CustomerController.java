package lk.earth.practical3.controller;

import lk.earth.practical3.dao.CustomerDao;
import lk.earth.practical3.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping
    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Integer id) {
        Optional<Customer> optionalCustomer = customerDao.findById(id);
        if (optionalCustomer.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
            return optionalCustomer.get();
        }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        if (!customerDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
        customerDao.deleteById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer add(@RequestBody Customer customer) {return customerDao.save(customer);}

    @PutMapping("/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer customer) {
        if (!customerDao.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");

        customer.setId(id);
        return customerDao.save(customer);
    }
}














