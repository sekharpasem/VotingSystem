package com.zen3.sekhar.votingsystem.config;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author Shekar
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * AppInitializer constructor
	 */
	public AppInitializer() {
		super();
		logger.info("AppInitializer loading.");
	}

	/**
	 * 
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, MongoConfig.class, WebAppConfig.class };
	}

	/**
	 * 
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {};
	}

	/**
	 * 
	 */
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {};
	}

	/**
	 * 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
