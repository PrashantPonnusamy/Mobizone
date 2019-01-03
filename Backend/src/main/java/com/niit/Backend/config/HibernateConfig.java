package com.niit.Backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.niit.Backend.dto"} )
@EnableTransactionManagement

public class HibernateConfig {
	
	
	
	
	private final static String DATABASE_URl= "jdbc:h2:tcp://localhost/~/Mobizone";
	private final static String DATABASE_DRIVER= "org.h2.driver";
	private final static String DATABASE_DIALECT= "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME= "prashant";
	private final static String DATABASE_PASSWORD= "Prashant12";
	
	
	
	//DataSource bean will be available
	@Bean
	public DataSource getDataSource() {
		
		
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URl);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		
		return dataSource;
		
		
	}
	
	//SessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niit.Backend.dto");
		
		
		
		
		return builder.buildSessionFactory();
		
		
		
	}
	
	
	
    //all the hibernate properties will be return in this method
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		
		properties.put("hibernate.show_sql", "true");
		
		properties.put("hibernate.format.sql", "true");
		
		
		return properties;
	}
	
	
	//transactionmanager bean will be available
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
		
		
	}
	
	
	
	
}
