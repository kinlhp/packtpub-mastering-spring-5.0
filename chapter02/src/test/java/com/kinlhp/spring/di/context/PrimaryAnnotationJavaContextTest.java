package com.kinlhp.spring.di.context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { PrimaryAnnotationSpringContext.class })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class PrimaryAnnotationJavaContextTest {

    @Autowired
    private SortingAlgorithm algorithm;

    @Test
    public void shouldBeMergeSortAlgorithm() throws Exception {
        Assert.assertEquals(MergeSort.class, algorithm.getClass());
    }
}
