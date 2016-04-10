package com.sales.dao;

import com.sales.SalesOrderTestApp2Application;
import com.sales.domain.Customer;
import com.sales.domain.Order;
import com.sales.domain.Product;
import com.sales.domain.ProductsInOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sigora on 07.04.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesOrderTestApp2Application.class)
@Transactional
@Rollback(true)
public class OrderDaoTest extends GenericTest{

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired ProductInOrderDao productOrderDao;


    @Test
    public void createOrderTest(){
        Customer customer = createCustomer();
        customer = customerDao.save(customer);

        Product product1 = createProduct();
        product1 = productDao.save(product1);
        Product product2 = createProduct();
        product2 = productDao.save(product2);

        Order order = new Order();
        order.setCustomer(customer);
        order.setNumber("Number" + System.nanoTime());
        order = orderDao.save(order);

        ProductsInOrder pio1 = new ProductsInOrder(order,product1,10L);
        ProductsInOrder pio2 = new ProductsInOrder(order,product1,11L);
        ProductsInOrder pio3 = new ProductsInOrder(order,product2,12L);

        pio1 = productOrderDao.save(pio1);
        pio2 = productOrderDao.save(pio2);
        pio3 = productOrderDao.save(pio3);

        order.getProductList().add(pio1);
        order.getProductList().add(pio2);
        order.getProductList().add(pio3);
        order = orderDao.save(order);

        Order savedOrder = orderDao.findOne(order.getId());

        Assert.assertTrue("Order not saved correctly", savedOrder.getProductList().size() == 3);
    }
}
