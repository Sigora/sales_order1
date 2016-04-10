package com.sales.dao.impl;

import com.sales.dao.CustomOrderDao;
import com.sales.domain.Order;
import com.sales.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by starnakin on 09.04.2016.
 */
@Repository
public class CustomOrderDaoImpl implements CustomOrderDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order getOrderByNumber(String number) {
        List<Order> resultList =  entityManager.createNamedQuery("from Order where number = :number", Order.class)
                .setParameter("number", number).getResultList();

        if(!resultList.isEmpty()){
            return resultList.get(0);
        }

        return null;
    }
}
