package com.sales.dao;

import com.sales.domain.ProductsInOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by starnakin on 09.04.2016.
 */
public interface ProductInOrderDao extends CrudRepository<ProductsInOrder,Long>{
}
