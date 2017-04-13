package com.zen3.sekhar.votingsystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * AppConfig
 * 
 * @author Shekar
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zen3.sekhar.votingsystem.*")
public class AppConfig {
	/**
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * AppConfig constructor
	 */
	public AppConfig() {
		logger.info("AppConfig loading.");
	}
}
