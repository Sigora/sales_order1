package com.sales.controllers;

import com.sales.dao.OrderDao;
import com.sales.domain.Order;
import com.sales.services.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sigora on 05.04.2016.
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SalesOrderService salesOrderService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order created = salesOrderService.createOrder(order);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Order> getOrderList() {
        return orderDao.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteOrder(@RequestBody String number) {
        try {
            Order order = orderDao.getOrderByNumber(number);
            orderDao.delete(order);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/get/{number}", method = RequestMethod.GET)
    public ResponseEntity<Order> getProductByCode(@PathVariable("number") String number){
        Order order = orderDao.getOrderByNumber(number);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
