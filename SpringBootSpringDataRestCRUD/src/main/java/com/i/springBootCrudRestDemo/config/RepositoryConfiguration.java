package com.i.springBootCrudRestDemo.config;


import com.i.springBootCrudRestDemo.model.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Student.class);
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
    }
}
