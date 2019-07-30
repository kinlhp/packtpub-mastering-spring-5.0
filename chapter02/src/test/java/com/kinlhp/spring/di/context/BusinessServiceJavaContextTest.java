package com.kinlhp.spring.di.context;

import com.kinlhp.spring.di.bean.User;
import com.kinlhp.spring.di.business.BusinessService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { SpringContext.class })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class BusinessServiceJavaContextTest {
    private static final User DUMMY_USER = new User("dummy");

    @Autowired
    private BusinessService service;

    @Test
    public void testCalculateSum() throws Exception {
        long sum = this.service.calculateSum(DUMMY_USER);
        Assert.assertEquals(39, sum);
    }
}
