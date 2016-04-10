package com.sales.dao;

import com.sales.domain.Order;

/**
 * Created by starnakin on 09.04.2016.
 */
public interface CustomOrderDao {
    Order getOrderByNumber(String number);
}
