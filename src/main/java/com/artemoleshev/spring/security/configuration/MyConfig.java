package com.artemoleshev.spring.security.configuration;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.artemoleshev.spring.security")
@EnableWebMvc
public class MyConfig {
	
	@Bean
	public ViewResolver viewResolder() {
		InternalResourceViewResolver internalResourceViewResolver = 
				new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public ComboPooledDataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/my_db?useSSL=false");
			dataSource.setUser("postgres");
			dataSource.setPassword("0975");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataSource;
	}
}


//	<bean
//	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//	<property name="prefix" value="/WEB-INF/view/" />
//	<property name="suffix" value=".jsp" />
//	</bean>