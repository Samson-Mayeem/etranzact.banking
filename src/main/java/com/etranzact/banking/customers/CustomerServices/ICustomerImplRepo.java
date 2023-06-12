package com.etranzact.banking.customers.CustomerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.etranzact.banking.customers.Customer;
import java.util.Optional;

@Repository
public interface ICustomerImplRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(long id);
}
