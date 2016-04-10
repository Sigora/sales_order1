package com.sales.dao.impl;

import com.sales.dao.CustomCustomerDao;
import com.sales.domain.Customer;
import com.sales.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by starnakin on 09.04.2016.
 */
@Repository
public class CustomCustomerDaoImpl implements CustomCustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer getCustomerByCode(String code) {
        List<Customer> resultList =  entityManager.createNamedQuery("from Customer where code = :code", Customer.class)
                .setParameter("code", code).getResultList();

        if(!resultList.isEmpty()){
            return resultList.get(0);
        }

        return null;
    }
}
