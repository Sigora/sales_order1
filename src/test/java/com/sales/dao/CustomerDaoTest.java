package com.sales.dao;

import com.sales.SalesOrderTestApp2Application;
import com.sales.domain.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by starnakin on 06.04.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesOrderTestApp2Application.class)
@Transactional
@Rollback(true)
public class CustomerDaoTest extends GenericTest{

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void saveCustomerTest(){

        Customer savedCustomer = customerDao.save(createCustomer());

        Assert.assertNotNull(savedCustomer.getId());
        Assert.assertNotNull(savedCustomer.getCode());
        Assert.assertNotNull(savedCustomer.getName());
        Assert.assertNotNull(savedCustomer.getPhone1());
        Assert.assertNotNull(savedCustomer.getCreditLimit());
        Assert.assertNotNull(savedCustomer.getCurrentCredit());
    }

    @Test
    public void getCustomerListTest(){
        customerDao.save(createCustomer());
        customerDao.save(createCustomer());
        customerDao.save(createCustomer());

        Assert.assertTrue("Customers list is empty", getCustomerList().size() >= 3);
    }

    @Test
    public void deleteCustomer(){
        Customer customer = customerDao.save(createCustomer());

        int custListSizeBeforeDelete = getCustomerList().size();

        customerDao.delete(customer);

        int custListSizeAfterDelete = getCustomerList().size();

        Assert.assertTrue("Customer wasn't deleted", custListSizeBeforeDelete - 1 == custListSizeAfterDelete);
    }

    @Test
    public void updateCustomer(){
        Customer customer = customerDao.save(createCustomer());

        String newName = "New name";

        customer.setName(newName);

        customerDao.save(customer);

        Customer customerAfterUpdate = customerDao.findOne(customer.getId());

        Assert.assertEquals(customerAfterUpdate.getName(), newName);
    }

    private List<Customer> getCustomerList(){
        List<Customer> customers = new ArrayList<>();
        customerDao.findAll().forEach(r -> customers.add(r));

        return customers;
    }

}
