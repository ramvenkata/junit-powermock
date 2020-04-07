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
@PrepareForTest(MyClassWithStaticMethods.class)
public class MyClassWithStaticMethodsTest {

	private static final Class<?> RETURNS_SMART_NULLS = null;

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
	public void test() {
		PowerMockito.mockStatic(MyClassWithStaticMethods.class);
		PowerMockito.when(MyClassWithStaticMethods.getFullName(Mockito.anyString(), Mockito.anyString())).thenReturn("Mocked Name");
		Mockito.when(MyClassWithStaticMethods.multiply(Mockito.anyInt(), Mockito.anyInt())).thenReturn(9);
		Mockito.when(MyClassWithStaticMethods.getPIValue()).thenReturn(2.13);
		
		assertEquals("Mocked Name", MyClassWithStaticMethods.getFullName("firstName", "lastName"));
		assertEquals("Mocked Name", MyClassWithStaticMethods.getFullName("firstName2", "lastName2"));
		
		PowerMockito.verifyStatic(MyClassWithStaticMethods.class, Mockito.times(2));
		MyClassWithStaticMethods.getFullName(Mockito.anyString(), Mockito.anyString());
		
		assertEquals(9, MyClassWithStaticMethods.multiply(2, 5));
		PowerMockito.verifyStatic(MyClassWithStaticMethods.class);
		MyClassWithStaticMethods.multiply(Mockito.anyInt(), Mockito.anyInt());
		
		PowerMockito.verifyStatic(MyClassWithStaticMethods.class, Mockito.never());
		MyClassWithStaticMethods.getPIValue();
	}

}
