package com.zen3.sekhar.votingsystem.service;

import com.zen3.sekhar.votingsystem.exception.MotionException;
import com.zen3.sekhar.votingsystem.model.Motion;

public interface VotingService {
	/**
	 * starts motion
	 * 
	 * @param name
	 * @param userRole
	 * @throws MotionException
	 */
	Motion startMotion(String name, String userRole) throws MotionException;

	/***
	 * make a vote
	 * 
	 * @param userName
	 * @param voteTo
	 * @param motionName
	 * @throws MotionException
	 */
	void voteOfUsers(String userName, String userRole, String voteTo, String motionName) throws MotionException;

	/***
	 * get motion state
	 * 
	 * @param name
	 * @throws MotionException
	 */
	String getMotionState(String name) throws MotionException;

	/**
	 * gets motion details
	 * 
	 * @param name
	 * @throws MotionException
	 */
	Motion getMotion(String name) throws MotionException;

	/**
	 * close motion
	 * 
	 * @param name
	 * @return
	 */
	Motion closeMotion(String name) throws MotionException;

	/**
	 * open motion
	 * 
	 * @param name
	 * @return
	 */
	Motion openMotion(String name) throws MotionException;

}
