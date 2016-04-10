package com.sales.dao;

import com.sales.domain.Product;

/**
 * Created by starnakin on 09.04.2016.
 */
public interface CustomProductDao {
    Product getProductByCode(String code);
}
