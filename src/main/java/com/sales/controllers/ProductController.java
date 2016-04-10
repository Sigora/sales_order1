package com.sales.controllers;

import com.sales.dao.ProductDao;
import com.sales.domain.Product;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveCustomer(@RequestBody Product product) {
        Product created = productDao.save(product);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteProduct(@RequestBody String code) {
        try {
            Product product = productDao.getProductByCode(code);
            productDao.delete(product);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Product> getProductList() {
        return productDao.findAll();
    }

    @RequestMapping(value = "/list/code_description", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodeDescriptionDto> getCustomerCodeDescriptionList() {
        List<CodeDescriptionDto> codeList = new ArrayList<>();
        productDao.findAll().forEach(e -> codeList.add(new CodeDescriptionDto(e.getCode(), e.getDescription())));
        return codeList;
    }

    @RequestMapping(value = "/get/{code}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductByCode(@PathVariable("code") String code){
       Product product = productDao.getProductByCode(code);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
