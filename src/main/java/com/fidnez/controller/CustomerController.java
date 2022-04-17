package com.fidnez.controller;

import com.fidnez.domain.Customer;
import com.fidnez.repository.CustomerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/customers")
public class CustomerController {

    @Autowired
    private CustomerDAOImpl customerDAO;

    @GetMapping("/id/{id}")
    public void findById(@PathVariable Long id) {

    }

    @GetMapping("/name/{name}")
    public List<Customer> findByName(@PathVariable String name) {
        customerDAO.load();
        Customer customer = new Customer();
        customer.setName("bob");
        return customerDAO.findByInput(customer);
    }

    @GetMapping("/groupByZip")
    public void findAllGroupByZip() {

    }

}
