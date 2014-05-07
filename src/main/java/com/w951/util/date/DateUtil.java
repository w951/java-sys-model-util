package com.w951.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 获取当前日期时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * 将字符串格式日期转换为UTC时间
	 * @param datetime yyyy-MM-dd HH:mm:ss
	 * @return long 精确到秒
	 * @throws ParseException
	 */
	public static long getUTC(String datetime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long millionSeconds = sdf.parse(datetime).getTime() / 1000; // 毫秒
		return millionSeconds;
	}
}
