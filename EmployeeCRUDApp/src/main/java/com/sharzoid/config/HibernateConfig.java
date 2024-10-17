package com.sharzoid.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	// Configure the DataSource bean (Database connection)
		@Bean
		public DataSource dataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			// HikariDataSource dataSource = new HikariDataSource();
			dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
			dataSource.setUrl("jdbc:hsqldb:hsql://localhost/");
			// dataSource.setJdbcUrl(env.getProperty( "jdbc:hsqldb:hsql://localhost/" )); //
			// Change to your DB
			dataSource.setUsername("SA");
			dataSource.setPassword("");
			return dataSource;
		}

		// Configure the SessionFactory bean (Hibernate SessionFactory)
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			System.out.println("sessionFactory begin-------");
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan("com.sharzoid.controller"); // Entity package
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
		}

		// Hibernate properties
		private Properties hibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.hbm2ddl.auto", "update");

			return properties;
		}
}
