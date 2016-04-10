package com.sales.dao;

import com.sales.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by starnakin on 06.04.2016.
 */
public interface CustomerDao extends PagingAndSortingRepository<Customer, Long>
        ,CrudRepository<Customer, Long>, CustomCustomerDao {
}
