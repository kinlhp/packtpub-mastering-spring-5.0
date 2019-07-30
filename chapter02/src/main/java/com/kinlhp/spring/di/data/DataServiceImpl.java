package com.kinlhp.spring.di.data;

import java.util.Collection;
import java.util.Set;

import com.kinlhp.spring.di.bean.Data;
import com.kinlhp.spring.di.bean.User;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(scopeName = "singleton")
public class DataServiceImpl implements DataService {

    @Override
    public Collection<Data> retrieveData(final User user) {
        return Set.of(new Data(19), new Data(20));
    }
}
