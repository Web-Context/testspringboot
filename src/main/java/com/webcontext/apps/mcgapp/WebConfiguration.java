package com.webcontext.apps.mcgapp;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Add specific configuration for the embedded H2 database console.
 * 
 * @author Frédéric Delorme
 *
 */
@Configuration
public class WebConfiguration {

	@Bean
	 ServletRegistrationBean h2servletRegistration() {
	 	// Route "/console/*" to the H2 console web application.
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
