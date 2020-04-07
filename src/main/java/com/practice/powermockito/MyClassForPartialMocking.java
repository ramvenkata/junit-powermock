/**
 * 
 */
package com.practice.powermockito;

/**
 * @author Ramesh
 *
 */
public class MyClassForPartialMocking {

	public static String staticMethod() {
		return "I am a static method";
	}
	
	public final String finalMethod() {
		return "I am a final method";
	}
	
	private String privateMethod() {
		return "I am a private method";
	}

	public String publicMethod() {
		return "Response from private method = " + privateMethod();
	}
}
