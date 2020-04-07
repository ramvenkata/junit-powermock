/**
 * 
 */
package com.practice.powermockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import java.time.LocalDateTime;

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
@PrepareForTest(com.practice.powermockito.MyClassWithFinalMethods.class)
public class MyClassWithFinalMethodsTest {

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
	public void test_mocking_final_methods() throws Exception {

		// mocking a class with a final method using PowerMockito
		MyClassWithFinalMethods mock = PowerMockito.mock(MyClassWithFinalMethods.class);

		// returning the mocked object
		PowerMockito.whenNew(MyClassWithFinalMethods.class).withNoArguments().thenReturn(mock);

		MyClassWithFinalMethods collaborator = new MyClassWithFinalMethods();

		// verify if the no arg constructor is called or not
		PowerMockito.verifyNew(MyClassWithFinalMethods.class).withNoArguments();

		PowerMockito.when(mock.getName()).thenReturn("Mocked Result");

		assertEquals("Mocked Result", collaborator.getName());

		// verify final method execution through Mockito
		//Mockito.verify(collaborator).helloMethod();
		Mockito.verify(collaborator, times(1)).getName();

	}

	@Test
	public void test_mocking_final_methodsV2() throws Exception {
		
		MyClassWithFinalMethods mock = PowerMockito.mock(MyClassWithFinalMethods.class);
		PowerMockito.whenNew(MyClassWithFinalMethods.class).withAnyArguments().thenReturn(mock);
		
		LocalDateTime now = LocalDateTime.now();
		MyClassWithFinalMethods myClass = new MyClassWithFinalMethods(now);
		PowerMockito.verifyNew(MyClassWithFinalMethods.class).withArguments(now);
	}
}
