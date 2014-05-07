package com.w951.util.algorithm.math.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.w951.util.algorithm.math.Arithmetic;

public class ArithmeticTest {
	private static Arithmetic arithmetic = new Arithmetic();
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testAddDoubleDouble() {
		double result = arithmetic.add(1.5, 1.2);
		assertThat(result, is(2.7));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testAddStringString() {
		String result = arithmetic.add("1.5", "1.2");
		assertThat(result, is("2.7"));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testSubtractDoubleDouble() {
		double result = arithmetic.subtract(1.5, 1.2);
		assertThat(result, is(0.3));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testSubtractStringString() {
		String result = arithmetic.subtract("3.5", "1.25");
		assertThat(result, is("2.25"));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testMultiplyDoubleDouble() {
		double result = arithmetic.multiply(1.5, 1.2);
		assertThat(result, is(1.8));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testMultiplyStringString() {
		String result = arithmetic.multiply("1.5", "1.2");
		assertThat(result, is("1.80"));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDivideDoubleDouble() {
		double result = arithmetic.divide(1.5, 1.2);
		assertThat(result, is(1.25));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testDivideDoubleDoubleInt() {
		double result = arithmetic.divide(10, 3, 2);
		assertThat(result, is(3.33));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testDivideStringString() {
		String result = arithmetic.divide("2.5", "2");
		assertThat(result, is("1.2500000000"));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testDivideStringStringInt() {
		String result = arithmetic.divide("10", "3", 2);
		assertThat(result, is("3.33"));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testRoundDoubleInt() {
		double result = arithmetic.round(3.1415926, 2);
		assertThat(result, is(3.14));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testRoundStringInt() {
		String result = arithmetic.round("3.1415926", 2);
		assertThat(result, is("3.14"));
	}
	
	//Exception Test
	
	@SuppressWarnings("static-access")
	@Test
	public void testDivideByZero() {
		expectedEx.expect(ArithmeticException.class);
	    expectedEx.expectMessage("The divisor cannot be zero");
		arithmetic.divide(1.5, 0);
	}

}
