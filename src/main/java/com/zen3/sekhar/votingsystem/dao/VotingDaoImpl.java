package com.zen3.sekhar.votingsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zen3.sekhar.votingsystem.model.Motion;
import com.zen3.sekhar.votingsystem.repository.MotionRepository;

/**
 * 
 * @author Shekar
 *
 */
@Repository
public class VotingDaoImpl implements VotingDao {
	@Autowired
	MotionRepository motionRepository;

	public Motion getMotion(String name) {
		return motionRepository.findByName(name);
	}

	public Motion saveMotion(Motion motion) {
		return motionRepository.save(motion);
	}

}
