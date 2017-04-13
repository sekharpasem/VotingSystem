package com.zen3.sekhar.votingsystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

/**
 * 
 * 
 * @author Sekhar
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.zen3.sekhar.votingsystem.repository")
public class MongoConfig extends AbstractMongoConfiguration {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public MongoConfig() {
		logger.info("MongoConfiguration loading.");
	}

	@Override
	protected String getDatabaseName() {
		return "voting-system";
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.zen3.sekhar.votingsystem.repository";
	}

	@Override
	@Bean
	public MongoClient mongo() throws Exception {

		MongoClient client = new MongoClient("127.0.0.1", 27017);
		client.setWriteConcern(WriteConcern.SAFE);
		return client;
	}

	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}

}