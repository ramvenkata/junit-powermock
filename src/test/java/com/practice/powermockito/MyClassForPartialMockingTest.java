/**
 * 
 */
package com.practice.powermockito;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Ramesh
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClassForPartialMocking.class)
public class MyClassForPartialMockingTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_static_private_final_methods_invocations() throws Exception {
		PowerMockito.spy(MyClassForPartialMocking.class);
		Mockito.when(MyClassForPartialMocking.staticMethod()).thenReturn("I am a mocked static method");
		
		assertEquals("I am a mocked static method", MyClassForPartialMocking.staticMethod());
		PowerMockito.verifyStatic(MyClassForPartialMocking.class);
		MyClassForPartialMocking.staticMethod();
		
		MyClassForPartialMocking myClass = new MyClassForPartialMocking();
		MyClassForPartialMocking mock = PowerMockito.spy(myClass);
		
		Mockito.when(mock.finalMethod()).thenReturn("I am a mocked final method");
		
		assertEquals("I am a mocked final method", mock.finalMethod());
		Mockito.verify(mock).finalMethod();
		
		PowerMockito.when(mock, "privateMethod").thenReturn("I am a private method");
		assertEquals("Response from private method = I am a private method", mock.publicMethod());
		PowerMockito.verifyPrivate(mock).invoke("privateMethod");
		
	}

}
