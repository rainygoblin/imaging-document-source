package com.axonmed.xds.source.initializer;


import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.IntrospectorCleanupListener;

public class AxonmedWebApplicationInitializer implements
		WebApplicationInitializer {
	private static final Logger logger = LoggerFactory
			.getLogger(AxonmedWebApplicationInitializer.class);
	
	public void onStartup(ServletContext sc) throws ServletException {
		logger.info("AxonmedWebApplicationInitializer.onStartup()");

		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.scan("com.axonmed.xds.source.config");
		// root.register(WebConfig.class);
		// root.scan(environment
		// .getProperty("webApplicationContext.scan.packages"));
		// root.getEnvironment().setDefaultProfiles("embedded");

		// Manages the lifecycle of the root application context
		sc.addListener(new ContextLoaderListener(root));

		sc.addListener(new IntrospectorCleanupListener());
		// Allows attributes to be accessed on the next request
//		sc.addFilter("flashMapFilter", FlashMapFilter.class)
//				.addMappingForUrlPatterns(null, false, "/*");

//		sc.addListener(new org.apache.shiro.web.env.EnvironmentLoaderListener());
		// Enables support for DELETE and PUT request methods with web browser
		// clients
		sc.addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class)
				.addMappingForUrlPatterns(null, false, "/*");

		// Secures the application
		/*sc.addFilter("shiroSecurityFilter",
				new DelegatingFilterProxy("shiroSecurityFilter"))
				.addMappingForUrlPatterns(null, false, "/*");*/

		// Handles requests into the application
		ServletRegistration.Dynamic appServlet = sc.addServlet("appServlet",
				new DispatcherServlet(new GenericWebApplicationContext()));
		appServlet.setLoadOnStartup(1);
		Set<String> mappingConflicts = appServlet.addMapping("/");
		if (!mappingConflicts.isEmpty()) {
			throw new IllegalStateException(
					"'appServlet' could not be mapped to '/' due "
							+ "to an existing mapping. This is a known issue under Tomcat versions "
							+ "<= 7.0.14; see https://issues.apache.org/bugzilla/show_bug.cgi?id=51278");
		}

		// for the spring web services configuration
		ServletRegistration.Dynamic jaxwsServlet = sc.addServlet("spring-ws",
				com.sun.xml.ws.transport.http.servlet.WSSpringServlet.class);
		jaxwsServlet.setLoadOnStartup(1);
		jaxwsServlet.addMapping("/services/*");
	}

}