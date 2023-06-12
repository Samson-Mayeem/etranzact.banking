package com.etranzact.banking.customers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @jakarta.persistence.Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence")
    private long Id;
    private String FirstName;
    private String LastName;
    private Date DoB;
    

    public Customer(long id, String firstName, String lastName, Date doB) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        DoB = doB;
    }
    public Customer(String firstName, String lastName, Date doB) {
        FirstName = firstName;
        LastName = lastName;
        DoB = doB;
    }
    public Customer() {
    }

}
