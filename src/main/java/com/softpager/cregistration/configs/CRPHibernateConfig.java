package com.softpager.cregistration.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class CRPHibernateConfig {
	
	@Autowired
	private Environment env;	
	//private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource softDataSource() {
		final JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
		dsLookUp.setResourceRef(true);
		DataSource softDataSource = dsLookUp.getDataSource("jdbc/icoursesdb");
		return softDataSource;
	}
	
	private Properties getHibernateProperties() {
		// set hibernate properties
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));		
		return props;			
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();		
		// set the properties
		sessionFactory.setDataSource(softDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());		
		return sessionFactory;
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













