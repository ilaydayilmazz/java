package com.i.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.i")
public class SpringRestAppConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
    @SuppressWarnings("serial")
	Properties hibernateProperties() {
	      return new Properties() {
	         {
	            setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
	            
	            	setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql")
	             );
	         }
	      };
    }
    
    
    
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.i.domain" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }

	@Bean
	public DataSource dataSource() {
	ComboPooledDataSource dataSource = new ComboPooledDataSource();
	try {
	dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driver"));
	} catch (Exception e) {
	e.printStackTrace();
	throw new RuntimeException();
	}
	dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
	dataSource.setUser(environment.getRequiredProperty("jdbc.user"));
	dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	dataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
	dataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
	dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));

	return dataSource;
	}
     
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}
	  
	     
	 



}

