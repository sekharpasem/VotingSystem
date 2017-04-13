package com.zen3.sekhar.votingsystem.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "motions")
public class Motion {
	@Id
	private String id;
	private String name;
	private String status;
	private long startDate;
	private long endDate;
	// motion inprogress date
	private long openedDate;
	// motion closed date
	private long closedDate;
	private List<String> votedUserList = new ArrayList<String>();
	private long forCount;
	private long againstCount;

	/**
	 * @return the openedDate
	 */
	public long getOpenedDate() {
		return openedDate;
	}

	/**
	 * @param openedDate
	 *            the openedDate to set
	 */
	public void setOpenedDate(long openedDate) {
		this.openedDate = openedDate;
	}

	/**
	 * @return the closedDate
	 */
	public long getClosedDate() {
		return closedDate;
	}

	/**
	 * @param closedDate
	 *            the closedDate to set
	 */
	public void setClosedDate(long closedDate) {
		this.closedDate = closedDate;
	}

	/**
	 * @return the forCount
	 */
	public long getForCount() {
		return forCount;
	}

	/**
	 * @param forCount
	 *            the forCount to set
	 */
	public void setForCount(long forCount) {
		this.forCount = forCount;
	}

	/**
	 * @return the againstCount
	 */
	public long getAgainstCount() {
		return againstCount;
	}

	/**
	 * @param againstCount
	 *            the againstCount to set
	 */
	public void setAgainstCount(long againstCount) {
		this.againstCount = againstCount;
	}

	/**
	 * @param name
	 * @param startDate
	 * @param endDate
	 */
	public Motion(String name, long startDate) {
		super();
		this.name = name;
		this.startDate = startDate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the startDate
	 */
	public long getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public long getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the votedUserList
	 */
	public List<String> getVotedUserList() {
		return votedUserList;
	}

	/**
	 * @param votedUserList
	 *            the votedUserList to set
	 */
	public void setVotedUserList(List<String> votedUserList) {
		this.votedUserList = votedUserList;
	}

}
