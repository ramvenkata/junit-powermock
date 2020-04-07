/**
 * 
 */
package com.practice.powermockito;

/**
 * @author Ramesh
 *
 */
public class MyClassWithStaticMethods {

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static String getFullName(String firstName, String lastName) {
		return String.join(" ", firstName, lastName);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int multiply(int x, int y) {
		return x * y;
	}
	
	/**
	 * 
	 * @return
	 */
	public static double getPIValue() {
		return Math.PI;
	}
}
