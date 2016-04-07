package com.sales.controllers;

import com.sales.dao.CustomerDao;
import com.sales.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Sigora on 05.04.2016.
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer created = customerDao.save(customer);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomer(@RequestBody Customer customer) {
        customerDao.delete(customer);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Customer> getCustomerList() {
        return customerDao.findAll();
    }
}
