package com.kinlhp.spring.di.business;

import com.kinlhp.spring.di.bean.User;
import com.kinlhp.spring.di.data.DataServiceImpl;

public class BusinessServiceImplBeforeRefactoring {

    public long calculateSum(final User user) {
        // tightly coupled
        return new DataServiceImpl().retrieveData(user).stream()
            .mapToLong(d -> d.getValue().orElseThrow())
            .sum();
    }
}
