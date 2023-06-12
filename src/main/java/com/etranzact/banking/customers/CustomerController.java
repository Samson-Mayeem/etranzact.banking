package com.etranzact.banking.customers;

import com.etranzact.banking.customers.CustomerServices.Impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public ResponseEntity<List<Customer>> GetAllCustomer(){
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @PostMapping("addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
    @PutMapping("updateCustomer/{id}")
    public ResponseEntity<Void> updateCustomer(
            @PathVariable("id") Long id,
            @RequestBody Customer customer) throws ChangeSetPersister.NotFoundException {

        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("deleteCustomer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
