package com.sales.dao;

import com.sales.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by starnakin on 06.04.2016.
 */
public interface ProductDao extends PagingAndSortingRepository<Product, Long>
        ,CrudRepository<Product, Long>, CustomProductDao {
}
