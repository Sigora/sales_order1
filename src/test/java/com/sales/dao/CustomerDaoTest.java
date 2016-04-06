package com.sales.dao;

import com.sales.SalesOrderTestApp2Application;
import com.sales.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by starnakin on 06.04.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesOrderTestApp2Application.class)
@Transactional
@Rollback(true)
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void saveCustomer(){
        Customer customer = new Customer();
        customer.setCode("code");
        customer.setName("name");
        customer.setPhone1("123456789");
        customer.setCreditLimit(2000.0);
        customer.setCurrentCredit(0.0);

        customerDao.save(customer);

    }
}
