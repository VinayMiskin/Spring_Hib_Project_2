package com.sharzoid.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(EmployeeAppConfig.class, HibernateConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

		ServletRegistration.Dynamic dynamic = servletContext.addServlet("spring", dispatcherServlet);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");

	}

}
