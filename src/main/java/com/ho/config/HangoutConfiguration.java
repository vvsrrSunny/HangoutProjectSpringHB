package com.ho.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate.HibernateTemplate;
import org.springframework.orm.hibernate.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

@Configuration
public class HangoutConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hangout");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        
        return dataSource;
	}
	    
	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	    {
	        HibernateTransactionManager htm = new HibernateTransactionManager();
	        htm.setSessionFactory(sessionFactory);
	        return htm;
	    }
	    
	    @Bean
	    @Autowired
	    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
	    {
	        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
	        return hibernateTemplate;
	    }
	        
	    @Bean
	    public AnnotationSessionFactoryBean getSessionFactory()
	    {
	        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
	        asfb.setDataSource(dataSource());
	        asfb.setHibernateProperties(getHibernateProperties());        
	        asfb.setPackagesToScan(new String[]{"com.ho"});
	        return asfb;
	    }

	    @Bean
	    public Properties getHibernateProperties()
	    {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", hibernateDialect);
	        properties.put("hibernate.show_sql", hibernateShowSql);
	        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
	        
	        return properties;
	    }
}
