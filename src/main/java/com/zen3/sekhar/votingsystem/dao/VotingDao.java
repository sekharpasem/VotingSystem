package com.zen3.sekhar.votingsystem.dao;

import com.zen3.sekhar.votingsystem.model.Motion;

public interface VotingDao {

	Motion getMotion(String name);

	Motion saveMotion(Motion motion);

}
