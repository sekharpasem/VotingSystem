package com.zen3.sekhar.votingsystem.util;

/**
 * 
 * @author Shekar
 *
 */
public class AppConstants {
	public enum MotionStatus {
		NOT_STARTED("NOT_STARTED"), INPROGRESS("INPROGRESS"), COMPLETED("COMPLETED"), TIED("TIED"), VOID("VOID");

		private final String name;

		private MotionStatus(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	public enum Roles {
		USER("USER"), SPEAKER("SPEAKER");

		private final String name;

		private Roles(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

}
