package com.sales.dao;

import com.sales.SalesOrderTestApp2Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sigora on 07.04.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SalesOrderTestApp2Application.class)
@Transactional
@Rollback(true)
public class OrderDaoTest {
}
