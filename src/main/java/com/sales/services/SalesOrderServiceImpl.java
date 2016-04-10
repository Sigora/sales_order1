package com.sales.services;

import com.sales.dao.CustomerDao;
import com.sales.dao.OrderDao;
import com.sales.dao.ProductDao;
import com.sales.domain.Customer;
import com.sales.domain.Order;
import com.sales.domain.Product;
import com.sales.exceptions.CustomerHaveNotEnoughtCredit;
import com.sales.exceptions.NotEnoughItemsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by starnakin on 09.04.2016.
 */
@Service
public class SalesOrderServiceImpl implements SalesOrderService{

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired CustomerDao customerDao;

    @Override
    @Transactional
    public Order createOrder(Order order) {
        validateQuantityIsEnough(order);
        validateCreditsIsEnough(order);

        //reduce product quantity
        order.getProductList().forEach(p -> {
            Product pr = productDao.getProductByCode(p.getProduct().getCode());
            pr.setQuantity(pr.getQuantity() - p.getQuantity());
            productDao.save(pr);

        });

        // customer update
        Double totalSum = order.getProductList().parallelStream()
                .mapToDouble(p -> p.getPriceOnSellMoment() * p.getQuantity()).sum();
        Customer customer = customerDao.getCustomerByCode(order.getCustomer().getCode());
        customer.setCurrentCredit(customer.getCurrentCredit() + totalSum);

        return orderDao.save(order);
    }

    private boolean validateQuantityIsEnough(Order order){
        order.getProductList().forEach(p -> {
            Product pr = productDao.getProductByCode(p.getProduct().getCode());
            if(pr.getQuantity() < p.getQuantity()){
                throw new NotEnoughItemsException();
            }
        });

        return true;
    }

    private boolean validateCreditsIsEnough(Order order){
        Customer customer = customerDao.getCustomerByCode(order.getCustomer().getCode());
        Double leftCredits = customer.getCreditLimit() - customer.getCurrentCredit();

        Double totalSum = order.getProductList().parallelStream()
                .mapToDouble(p -> p.getPriceOnSellMoment() * p.getQuantity()).sum();

        if(leftCredits < totalSum){
            throw new CustomerHaveNotEnoughtCredit();
        }

        return true;
    }
}
