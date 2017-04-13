package com.zen3.sekhar.votingsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zen3.sekhar.votingsystem.exception.MotionException;
import com.zen3.sekhar.votingsystem.model.Motion;
import com.zen3.sekhar.votingsystem.service.VotingService;

/**
 * 
 * @author Shekar
 *
 */
@RestController
@SuppressWarnings("rawtypes")
public class VotingController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	VotingService votingService;

	/**
	 * starts motion
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/motion/start/{name}/user/{userRole}")
	public ResponseEntity startMotion(@PathVariable("name") String name, @PathVariable("userRole") String userRole) {
		logger.info("startMotion:name={}", name);
		ResponseEntity response = null;
		try {
			if (name != null) {
				Motion motion = votingService.startMotion(name, userRole);
				response = ResponseEntity.ok(motion);
			} else {
				response = ResponseEntity.badRequest().body("Motion name should not be empty.");
			}
		} catch (MotionException e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;

	}

	/**
	 * accepts votes
	 * 
	 * @param userName
	 * @param userRole
	 * @param voteTo
	 * @param motionName
	 * @return
	 */
	@GetMapping("/accept-vote/motion/{motionName}/vote-to/{voteTo}/user/{name}/{userRole}")
	public ResponseEntity voteOfUser(@PathVariable("name") String userName, @PathVariable("userRole") String userRole,
			@PathVariable("voteTo") String voteTo, @PathVariable("motionName") String motionName) {
		logger.info("voteOfUser:name={},voteTo={},motionName={}", userName, voteTo, motionName);
		ResponseEntity response = null;
		try {
			if (userName != null) {
				votingService.voteOfUsers(userName, userRole, voteTo, motionName);
				response = ResponseEntity.ok("Success");
			}
		} catch (MotionException e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;

	}

	/**
	 * gets motion state
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/motion/{name}/state")
	public ResponseEntity getMotionState(@PathVariable("name") String name) {
		logger.info("getMotionState:name={}", name);
		ResponseEntity response = null;
		try {
			if (name != null) {
				String state = votingService.getMotionState(name);
				response = ResponseEntity.ok(state);
			}
		} catch (MotionException e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;

	}

	/**
	 * get motion details
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/motion/{name}")
	public ResponseEntity getMotion(@PathVariable("name") String name) {
		logger.info("getMotion:name={}", name);
		ResponseEntity response = null;
		try {
			if (name != null) {
				Motion motion = votingService.getMotion(name);
				response = ResponseEntity.ok(motion);
			}
		} catch (MotionException e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;

	}

	/***
	 * close motion
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/close-motion/{name}")
	public ResponseEntity closeMotion(@PathVariable("name") String name) {
		logger.info("closeMotion:name={}", name);
		ResponseEntity response = null;
		try {
			if (name != null) {
				Motion motion = votingService.closeMotion(name);
				response = ResponseEntity.ok(motion);
			}
		} catch (MotionException e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;

	}

	/**
	 * open motion
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/open-motion/{name}")
	public ResponseEntity openMotion(@PathVariable("name") String name) {
		logger.info("openMotion:name={}", name);
		ResponseEntity response = null;
		try {
			if (name != null) {
				Motion motion = votingService.openMotion(name);
				response = ResponseEntity.ok(motion);
			}
		} catch (MotionException e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;

	}
}
