package com.sales.dao.impl;

import com.sales.dao.CustomProductDao;
import com.sales.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by starnakin on 09.04.2016.
 */

@Repository
public class CustomProductDaoImpl implements CustomProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product getProductByCode(String code) {
        List<Product> resultList =  entityManager.createNamedQuery("from Product where code = :code", Product.class)
                .setParameter("code", code).getResultList();

        if(!resultList.isEmpty()){
            return resultList.get(0);
        }

        return null;
    }
}
