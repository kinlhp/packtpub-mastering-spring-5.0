package com.kinlhp.spring.di.context;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = { "com.kinlhp.spring" })
@Configuration
class PrimaryAnnotationSpringContext {
}

public class PrimaryAnnotationJavaContext {
    private static final Logger LOGGER = Logger.getLogger(PrimaryAnnotationJavaContext.class);

    public static void main(final String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(PrimaryAnnotationSpringContext.class);

        final SortingAlgorithm algorithm = context.getBean(SortingAlgorithm.class);
        LOGGER.debug(algorithm);

        final Service service = context.getBean(Service.class);
        LOGGER.debug(service.getAlgorithm());
    }
}

interface SortingAlgorithm {
}

@Component
@Primary
class MergeSort implements SortingAlgorithm {
}

@Component
@Qualifier(value = "quickSort")
class QuickSort implements SortingAlgorithm {
}

interface Service {

    SortingAlgorithm getAlgorithm();
}

@Component
class SomeService implements Service {
    private final SortingAlgorithm algorithm;

    @Autowired
    public SomeService(@Qualifier(value = "quickSort") final SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public SortingAlgorithm getAlgorithm() {
        return this.algorithm;
    }
}
