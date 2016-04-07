package com.sales.controllers;

import com.sales.dao.CustomerDao;
import com.sales.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sigora on 05.04.2016.
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CustomerDao productDao;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer product) {
        Customer created = productDao.save(product);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomer(@RequestBody Customer product) {
        productDao.delete(product);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Customer> getCustomerList() {
        return productDao.findAll();
    }


}
