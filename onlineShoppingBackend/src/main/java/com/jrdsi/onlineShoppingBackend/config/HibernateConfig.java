package com.jrdsi.onlineShoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class HibernateConfig {
	
	private static final String URL = "jdbc:h2:tcp://localhost/~/onlineShopping";
	
	private static final String DRIVER = "org.h2.Driver";
	
	private static final String DIALECT = "org.hibernate.dialect.H2Dialect";
	
	private static final String USER_NAME = "system";
	
	private static final String PASSWORD = "admin";
	
 // To create dataSource bean that contains database connection info
	@Bean("dataSource")
	public DataSource getDataSource(){
		 BasicDataSource dataSource = new BasicDataSource();
		 //providing the database connection information
		 
		 dataSource.setDriverClassName(DRIVER);
		 dataSource.setUrl(URL);
		 dataSource.setUsername(USER_NAME);
		 dataSource.setPassword(PASSWORD);
		 
		 return dataSource;
	}
	
	//Create SessionFactory Bean for Hibernate Config
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHiberNateProperties());
		builder.scanPackages("com.jrdsi.onlineShoppingBackend.dto");
		
		return builder.buildSessionFactory();
	}
	
	//generate Hibernate Transaction Manager bean
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory factory){
		HibernateTransactionManager txManager = new HibernateTransactionManager(factory);
		return txManager;
		
	}

	//Set all the hibernate Properties and return it
	private Properties getHiberNateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DIALECT);
		properties.put("hibernate.show_sql", "true");
 		properties.put("hibernate.format_sql", "true");
 		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
