package com.sales.dao;

import com.sales.SalesOrderTestApp2Application;
import com.sales.domain.Customer;
import com.sales.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sigora on 07.04.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesOrderTestApp2Application.class)
@Transactional
@Rollback(true)
public class ProductDaoTest extends GenericTest{

    @Autowired
    private ProductDao productDao;

    @Test
    public void saveProductTest(){
        Product product = productDao.save(createProduct());

        Assert.assertNotNull(product.getId());
    }

    @Test
    public void loadProductListTest(){
        productDao.save(createProduct());
        productDao.save(createProduct());

        Assert.assertTrue("Not all products was loaded", getProductsList().size() >= 2);
    }

    @Test
    public void deleteProduct(){
        Product product = productDao.save(createProduct());

        int prodListSizeBeforeDelete = getProductsList().size();

        productDao.delete(product);

        int prodListSizeAfterDelete = getProductsList().size();

        Assert.assertTrue("Customer wasn't deleted", prodListSizeBeforeDelete - 1 == prodListSizeAfterDelete);
    }

    @Test
    public void updateProduct(){
        Product product = productDao.save(createProduct());

        String newCode = "new code";

        product.setCode(newCode);

        productDao.save(product);

        Product productAfterUpdate = productDao.findOne(product.getId());

        Assert.assertEquals(productAfterUpdate.getCode(), newCode);
    }

    private List<Product> getProductsList(){
        List<Product> products = new ArrayList<>();
        productDao.findAll().forEach(r -> products.add(r));

        return products;
    }

}
