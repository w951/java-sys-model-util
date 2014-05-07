package com.w951.util.algorithm.gps;

import java.math.BigDecimal;

/**
 * 经纬度转换
 * 
 * @author lusifer
 */
public class ConverLngLat {
	private static final double EARTH_RADIUS = 6378137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 经纬度度分秒转换为小数
	 * 
	 * @param du 度数
	 * @param fen 分数
	 * @param miao 秒数
	 * @return 小数形式的经纬度
	 */
	public static double convertToDecimal(double du, double fen, double miao) {
		if (du < 0)
			return -(Math.abs(du) + (Math.abs(fen) + (Math.abs(miao) / 60)) / 60);
		return Math.abs(du) + (Math.abs(fen) + (Math.abs(miao) / 60)) / 60;
	}

	/**
	 * 以字符串形式输入经纬度的转换
	 * 
	 * @param latlng 经纬度的字符串形式
	 * @return 小数形式的经纬度
	 */
	public static double convertToDecimalByString(String latlng) {
		double du = 0;
		double fen = 0;
		double miao = 0;
		if (latlng.indexOf("°") != -1) {
			du = Double.parseDouble(latlng.substring(0, latlng.indexOf("°")));
			if (latlng.indexOf("′") != -1) {
				fen = Double.parseDouble(latlng.substring(latlng.indexOf("°") + 1,
						latlng.indexOf("′")));
				if (latlng.indexOf("″") != -1) {
					miao = Double.parseDouble(latlng.substring(latlng.indexOf("′") + 1,
							latlng.indexOf("″")));
				}
			}
		}

		if (du < 0)
			return -(Math.abs(du) + (fen + (miao / 60)) / 60);
		return du + (fen + (miao / 60)) / 60;
	}

	/**
	 * 将小数转换为度分秒
	 * 
	 * @param lnglat 经纬度
	 * @return 字符串形式的经纬度
	 */
	public static String convertToSexagesimal(double lnglat) {
		int du = (int) Math.floor(Math.abs(lnglat)); // 获取整数部分
		double temp = getPoint(Math.abs(lnglat)) * 60;
		int fen = (int) Math.floor(temp); // 获取整数部分
		double miao = getPoint(temp) * 60;
		if (lnglat < 0)
			return "-" + du + "°" + fen + "′" + miao + "″";

		return du + "°" + fen + "′" + miao + "″";
	}

	/**
	 * 根据经纬度计算两点之间的距离
	 * 
	 * @param lngA A点经度
	 * @param latA A点纬度
	 * @param lngB B点经度
	 * @param latB B点纬度
	 * @return 两点之间的直线距离，单位：米
	 */
	public static long getDistance(double lngA, double latA, double lngB, double latB) {
		double radLat1 = rad(latA);
		double radLat2 = rad(latB);
		double a = radLat1 - radLat2;
		double b = rad(lngA) - rad(lngB);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
				* Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return new Double(s).longValue();
	}

	/**
	 * 获取小数部分
	 * 
	 * @param num
	 * @return
	 */
	private static double getPoint(double num) {
		double d = num;
		int fInt = (int) d;
		BigDecimal b1 = new BigDecimal(Double.toString(d));
		BigDecimal b2 = new BigDecimal(Integer.toString(fInt));
		double dPoint = b1.subtract(b2).floatValue();
		return dPoint;
	}
}
