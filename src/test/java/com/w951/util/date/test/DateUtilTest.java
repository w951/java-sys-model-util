package com.w951.util.date.test;

import java.text.ParseException;

import org.junit.Test;

import com.w951.util.date.DateUtil;

public class DateUtilTest {
	
	@Test
	public void testGetUTC() throws ParseException {
		System.out.println(DateUtil.getUTC("2014-05-06 12:32:11"));
	}
}
