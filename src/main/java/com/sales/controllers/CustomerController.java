package com.sales.controllers;

import com.sales.dao.CustomerDao;
import com.sales.domain.Customer;
import com.sales.dto.CodeDescriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sigora on 05.04.2016.
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer created = customerDao.save(customer);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCustomer(@RequestBody String code) {
        try {
            Customer customer = customerDao.getCustomerByCode(code);
            customerDao.delete(customer);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> getCustomerList() {
        return customerDao.findAll();
    }

    @RequestMapping(value = "/list/code_description", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodeDescriptionDto> getCustomerCodeDescriptionList() {
        List<CodeDescriptionDto> codeList = new ArrayList<>();
        customerDao.findAll().forEach(e -> codeList.add(new CodeDescriptionDto(e.getCode(), e.getName())));
        return codeList;
    }

    @RequestMapping(value = "/get/{code}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getProductByCode(@PathVariable("code") String code){
        Customer customer = customerDao.getCustomerByCode(code);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
}
