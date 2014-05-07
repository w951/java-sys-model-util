package com.w951.util.algorithm.math;

/**
 * 概率
 * 
 * @author lusifer
 * 
 */
public class Probability {
	/**
	 * 0出现的概率为%50
	 */
	public static double rate0 = 0.50;
	/**
	 * 1出现的概率为%20
	 */
	public static double rate1 = 0.20;
	/**
	 * 2出现的概率为%15
	 */
	public static double rate2 = 0.15;
	/**
	 * 3出现的概率为%10
	 */
	public static double rate3 = 0.10;
	/**
	 * 4出现的概率为%4
	 */
	public static double rate4 = 0.04;
	/**
	 * 5出现的概率为%1
	 */
	public static double rate5 = 0.01;

	/**
	 * 0出现的概率为%50 <br />
	 * 1出现的概率为%20 <br />
	 * 2出现的概率为%15 <br />
	 * 3出现的概率为%10 <br />
	 * 4出现的概率为%4 <br />
	 * 5出现的概率为%1 <br />
	 * Math.random()产生一个double型的随机数，判断一下 例如0出现的概率为%50，则介于0到0.50中间的返回0
	 * @return int
	 * 
	 */
	public static int PercentageRandom() {
		double randomNumber;
		randomNumber = Math.random();
		if (randomNumber >= 0 && randomNumber <= rate0) {
			return 0;
		} else if (randomNumber >= rate0 / 100 && randomNumber <= rate0 + rate1) {
			return 1;
		} else if (randomNumber >= rate0 + rate1
				&& randomNumber <= rate0 + rate1 + rate2) {
			return 2;
		} else if (randomNumber >= rate0 + rate1 + rate2
				&& randomNumber <= rate0 + rate1 + rate2 + rate3) {
			return 3;
		} else if (randomNumber >= rate0 + rate1 + rate2 + rate3
				&& randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4) {
			return 4;
		} else if (randomNumber >= rate0 + rate1 + rate2 + rate3 + rate4
				&& randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4
						+ rate5) {
			return 5;
		}
		return -1;
	}
	
	/**
	 * 根据概率返回对应的值
	 * 0符合概率
	 * -1不符合概率
	 * @param rate 概率  0-1
	 * @return int
	 */
	public static int PercentageRandom(double rate) {
		double randomNumber;
		randomNumber = Math.random();
		if (randomNumber >= 0 && randomNumber <= rate) {
			return 0;
		}
		return -1;
	}
}
