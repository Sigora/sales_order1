package com.sales.dao;

import com.sales.domain.Customer;

/**
 * Created by starnakin on 09.04.2016.
 */
public interface CustomCustomerDao {
    Customer getCustomerByCode(String code);
}
