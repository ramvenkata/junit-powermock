/**
 * 
 */
package com.practice.powermockito;

import java.time.LocalDateTime;

/**
 * @author Ramesh
 *
 */
public class MyClassWithFinalMethods {

	private final LocalDateTime createdDate;
	
	/**
	 * 
	 */
	public MyClassWithFinalMethods() {
		this.createdDate = null;
	}

	/**
	 * 
	 * @param createdDate
	 */
	public MyClassWithFinalMethods(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 
	 * @return
	 */
	public final String getName() {
		return "Hello Method";
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollobaratorWithFinalMethods [createdDate=" + createdDate + "]";
	}

}
