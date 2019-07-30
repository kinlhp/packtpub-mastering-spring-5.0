package com.kinlhp.spring.di.data;

import java.util.Collection;

import com.kinlhp.spring.di.bean.Data;
import com.kinlhp.spring.di.bean.User;

public interface DataService {
    Collection<Data> retrieveData(final User user);
}
