package com.w951.util.algorithm.gps.test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.w951.util.algorithm.gps.ConverLngLat;

public class ConverLngLatTest {
	private static ConverLngLat converLngLat = new ConverLngLat();

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testConvertToDecimal() {
		double result = converLngLat.convertToDecimal(113, 45, 0.0);
		assertThat(result, closeTo(113.75, 0.000001));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testConvertToDecimalByString() {
		double result = converLngLat.convertToDecimalByString("113°45′0.0″");
		assertThat(result, closeTo(113.75, 0.000001));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testConvertToSexagesimal() {
		String result = converLngLat.convertToSexagesimal(113.75);
		assertThat(result, is("113°45′0.0″"));
	}

	@SuppressWarnings("static-access")
	@Test
	public void testGetDistance() {
		double result = converLngLat.getDistance(114.05762, 22.53170, 114.06051, 22.53000);
		assertThat(result, closeTo(352, 1));
	}

}
