package com.kinlhp.spring.di.context;

import java.util.Set;

import com.kinlhp.spring.di.bean.Data;
import com.kinlhp.spring.di.bean.User;
import com.kinlhp.spring.di.business.BusinessServiceImpl;
import com.kinlhp.spring.di.data.DataService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(value = MockitoJUnitRunner.class)
public class BusinessServiceMockitoTest {
    private static final User DUMMY_USER = new User("dummy");

    @Autowired
    @InjectMocks
    private BusinessServiceImpl businessService;

    @Mock
    private DataService dataService;

    @Test
    public void testCalculateSum() throws Exception {
        BDDMockito.given(dataService.retrieveData(Matchers.any(User.class)))
                .willReturn(Set.of(new Data(10), new Data(15), new Data(25)));
        long sum = businessService.calculateSum(DUMMY_USER);
        Assert.assertEquals((10 + 15 + 25), sum);
    }
}
