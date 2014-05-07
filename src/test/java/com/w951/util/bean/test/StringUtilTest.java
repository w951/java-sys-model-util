package com.w951.util.bean.test;

import org.junit.Test;

import com.w951.util.bean.StringUtil;

public class StringUtilTest {

//	@Test
	public void testToMd5() {
		System.out.println(StringUtil.toMD5("admin"));
	}
	
//	@Test
	public void testGetUUID() {
		for (int i = 0 ; i < 1 ; i++) {
			System.out.println(StringUtil.getUUID());
		}
	}
	
//	@Test
	public void testMd5ToInt() {
		String uuid = StringUtil.getUUID();
		String md5 = StringUtil.toMD5(uuid);
		System.out.println(md5);
	}
	
//	@Test
	public void testSystemPath() {
		System.out.println(System.getProperty("user.dir"));
	}
	
	@Test
	public void testRandom() {
		for (int i = 0 ; i < 100 ; i ++) {
			System.out.println(Math.round(Math.random()*(100 - 50) + 50));
		}
	}

}
