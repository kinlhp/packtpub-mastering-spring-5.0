package com.kinlhp.spring.di.context;

import com.kinlhp.spring.di.bean.User;
import com.kinlhp.spring.di.business.BusinessService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.kinlhp.spring" })
class SpringContext {
}

public class LaunchJavaContext {
    private static final User USER_DUMMY = new User("dummy");
    public static Logger logger = Logger.getLogger(LaunchJavaContext.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class);
        BusinessService service = context.getBean(BusinessService.class);
        logger.debug(service.calculateSum(USER_DUMMY));
    }
}
