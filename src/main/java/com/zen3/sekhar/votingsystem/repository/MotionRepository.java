package com.zen3.sekhar.votingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zen3.sekhar.votingsystem.model.Motion;

/**
 * Motion operations
 * 
 * @author Shekar
 *
 */
public interface MotionRepository extends MongoRepository<Motion, String> {

	Motion findByName(String name);

}
