package com.zen3.sekhar.votingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zen3.sekhar.votingsystem.dao.VotingDao;
import com.zen3.sekhar.votingsystem.exception.MotionException;
import com.zen3.sekhar.votingsystem.model.Motion;
import com.zen3.sekhar.votingsystem.util.AppConstants.MotionStatus;
import com.zen3.sekhar.votingsystem.util.AppConstants.Roles;

/**
 * 
 * @author Shekar
 *
 */
@Service
@Transactional
public class VotingServiceImpl implements VotingService {
	@Autowired
	VotingDao votingDao;

	/**
	 * starts motion
	 * 
	 * @param name
	 * @param userRole
	 * @throws MotionException
	 */
	public Motion startMotion(String name, String userRole) throws MotionException {
		Motion motion = null;
		if (name != null) {
			// check user is speaker or not
			if (!userRole.equals(Roles.SPEAKER.getName())) {
				throw new MotionException("Only speaker has access to start a new motion.");
			}
			try {
				motion = getMotion(name);
			} catch (MotionException e) {

			}
			if (motion != null) {
				throw new MotionException("Motion is already exist with given name. Please use other name.");
			}
			// start new motion with given name
			motion = new Motion(name, System.currentTimeMillis());
			motion.setStatus(MotionStatus.NOT_STARTED.getName());
			motion = votingDao.saveMotion(motion);
		}
		return motion;
	}

	/***
	 * make a vote
	 * 
	 * @param userName
	 * @param voteTo
	 * @param motionName
	 * @throws MotionException
	 */
	public void voteOfUsers(String userName, String userRole, String voteTo, String motionName) throws MotionException {
		Motion motion = null;
		if (userName != null && voteTo != null && motionName != null) {
			motion = getMotion(motionName);

			List<String> votedUserList = motion.getVotedUserList();

			// check motion is started
			if (motion.getStatus().equals(MotionStatus.INPROGRESS.getName())
					|| motion.getStatus().equals(MotionStatus.TIED.getName())) {

				if (motion.getStatus().equals(MotionStatus.TIED.getName())) {
					if (!userRole.equals(Roles.SPEAKER.getName())) {
						throw new MotionException("Only speaker is allowed to vote in tied state");
					}
				}
				// check maximum votes received on a motion is 51.
				if (votedUserList.size() > 50) {
					throw new MotionException("The maximum votes are exceeded.");
				}
				// check user is already voted
				if (votedUserList.contains(userName)) {
					throw new MotionException(userName + " is already voted.");
				}
				if (voteTo.equalsIgnoreCase("for")) {
					motion.setForCount(motion.getForCount() + 1);
				}
				if (voteTo.equalsIgnoreCase("against")) {
					motion.setAgainstCount(motion.getAgainstCount() + 1);
				}
				// add user to votedUsersList
				votedUserList.add(userName);
				motion.setVotedUserList(votedUserList);

				if (motion.getStatus().equals(MotionStatus.TIED.getName())) {
					motion.setStatus(MotionStatus.COMPLETED.getName());
				}

				votingDao.saveMotion(motion);
			} else {
				throw new MotionException("Motion not started or already closed.");
			}
		}
	}

	/***
	 * get motion state
	 * 
	 * @param name
	 * @throws MotionException
	 */
	public String getMotionState(String name) throws MotionException {
		if (name != null) {
			Motion motion = getMotion(name);
			return motion.getStatus();
		}
		return "Unknown";
	}

	/**
	 * gets motion details
	 * 
	 * @param name
	 * @throws MotionException
	 */
	public Motion getMotion(String name) throws MotionException {
		Motion motion = null;
		if (name != null) {
			motion = votingDao.getMotion(name);
			if (motion == null)
				throw new MotionException("Motion not found.");

		}
		return motion;
	}

	/**
	 * close motion sate
	 * 
	 * @param name
	 * @param state
	 * @return
	 * @throws MotionException
	 */
	public Motion closeMotion(String name) throws MotionException {
		Motion motion = null;
		if (name != null) {
			motion = votingDao.getMotion(name);
			// check motion is closed after 15 mins of open
			if ((motion.getOpenedDate() + 900000) > System.currentTimeMillis()) {
				throw new MotionException(
						"Motion cannot be closed for voting less than 15 minutes after it was opened.");
			}
			if (motion.getForCount() == motion.getAgainstCount()) {
				motion.setStatus(MotionStatus.TIED.getName());
			} else {
				motion.setStatus(MotionStatus.COMPLETED.getName());
				motion.setClosedDate(System.currentTimeMillis());
			}
			motion = votingDao.saveMotion(motion);
		}
		return motion;
	}

	/***
	 * open motion
	 * 
	 * @param name
	 * @throws MotionException
	 */
	public Motion openMotion(String name) throws MotionException {
		Motion motion = null;
		if (name != null) {
			motion = votingDao.getMotion(name);
			motion.setStatus(MotionStatus.INPROGRESS.getName());
			motion.setOpenedDate(System.currentTimeMillis());
			votingDao.saveMotion(motion);
		}
		return motion;
	}

}
