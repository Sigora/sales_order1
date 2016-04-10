package com.sales.dao;

import com.sales.domain.Customer;
import com.sales.domain.Product;

/**
 * Created by starnakin on 09.04.2016.
 */
public class GenericTest {
    public Product createProduct(){
        Product product = new Product();
        product.setCode("code" + System.nanoTime());
        product.setDescription("description");
        product.setPrice(99.9);
        product.setQuantity(99L);

        return product;
    }

    public Customer createCustomer(){
        Customer customer = new Customer();
        customer.setCode("code" + System.nanoTime());
        customer.setName("name");
        customer.setAddress("Address");
        customer.setPhone1("123456789");
        customer.setCreditLimit(222000.0);
        customer.setCurrentCredit(0.0);

        return customer;
    }

}
