package com.etranzact.banking.customers.CustomerServices.Impl;

import com.etranzact.banking.customers.Customer;
import com.etranzact.banking.customers.CustomerServices.ICustomerImplRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    private final ICustomerImplRepo iCustomerRepo;
    @Autowired
    public CustomerService(ICustomerImplRepo iCustomerRepo) {
        this.iCustomerRepo = iCustomerRepo;
    }

    public List<Customer> getCustomers(){
        return iCustomerRepo.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return iCustomerRepo.save(customer);
    }

    public void updateCustomer(Long id, Customer customer) throws ChangeSetPersister.NotFoundException {
        Customer existingCustomer = iCustomerRepo.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        // Update the properties of the existing customer object
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setDoB(customer.getDoB());

        iCustomerRepo.save(existingCustomer);
    }

    public void deleteCustomer(Long id) throws ChangeSetPersister.NotFoundException {
        Customer customer = iCustomerRepo.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        iCustomerRepo.delete(customer);
    }
}
