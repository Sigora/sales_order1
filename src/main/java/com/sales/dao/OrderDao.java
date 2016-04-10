package com.sales.dao;

import com.sales.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by starnakin on 09.04.2016.
 */
public interface OrderDao extends CrudRepository<Order,Long>, CustomOrderDao{
}
