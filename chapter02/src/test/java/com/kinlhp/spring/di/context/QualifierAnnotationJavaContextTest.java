package com.kinlhp.spring.di.context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { PrimaryAnnotationSpringContext.class })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class QualifierAnnotationJavaContextTest {

    @Autowired
    private Service service;

    @Test
    public void shouldBeQuickSortAlgorithm() throws Exception {
        final SortingAlgorithm algorithm = service.getAlgorithm();
        Assert.assertEquals(QuickSort.class, algorithm.getClass());
    }
}
