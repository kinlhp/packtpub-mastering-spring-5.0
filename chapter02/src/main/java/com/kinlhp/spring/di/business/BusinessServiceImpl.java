package com.kinlhp.spring.di.business;

import com.kinlhp.spring.di.bean.User;
import com.kinlhp.spring.di.data.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(scopeName = "singleton")
@Service
public class BusinessServiceImpl implements BusinessService {
    private final DataService dataService;

    @Autowired
    public BusinessServiceImpl(final DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public long calculateSum(final User user) {
        return this.dataService.retrieveData(user).stream()
        .mapToLong(d -> d.getValue().orElseThrow())
        .sum();
    }
}
