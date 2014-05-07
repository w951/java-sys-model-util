package com.w951.util.bean;

import java.util.regex.Pattern;

/**
 * 通用正则表达式工具
 * @author lwm
 *
 */
public class RegexpUtil {
	/**
	 * 纯数字
	 */
	public static final String EXP_NUMBER = "^[0-9]*$";
	/**
	 * 手机号
	 */
	public static final String EXP_MOBILE = "1[358]\\d{9}";
	/**
	 * 邮箱
	 */
	public static final String EXP_EMAIL = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
	/**
	 * QQ
	 */
	public static final String EXP_QQ = "[1-9][0-9]{4,14}";
	/**
	 * 字母数字下划线组合
	 */
	public static final String EXP_COMB = "^[0-9a-zA-Z_-]+$";
	/**
	 * 汉字
	 */
	public static final String EXP_CHINESE = "^[\u4e00-\u9fa5]+$";
	/**
	 * 字母
	 */
	public static final String EXP_ENGLISH = "^[a-zA-Z]+$";
	/**
	 * 标点符号
	 */
	public static final String EXP_PUNCTUATION = "[\\pP‘’“”]";
	
	
	/**
	 * 是否为数字
	 * @param input
	 * @return
	 */
	public static boolean isNumber(String input) {
		return Pattern.matches(EXP_NUMBER, input);
	}
	
	/**
	 * 是否为手机号
	 * @param input
	 * @return
	 */
	public static boolean isMobile(String input) {
		return Pattern.matches(EXP_MOBILE, input);
	}
	
	/**
	 * 是否为邮箱
	 * @param input
	 * @return
	 */
	public static boolean isEmail(String input) {
		return Pattern.matches(EXP_EMAIL, input);
	}
	
	/**
	 * 是否为QQ
	 * @param input
	 * @return
	 */
	public static boolean isQQ(String input) {
		return Pattern.matches(EXP_QQ, input);
	}
	
	/**
	 * 是否为字母\数字\下划线组合（不超出该范围）
	 * @param input
	 * @return
	 */
	public static boolean isComb(String input) {
		return Pattern.matches(EXP_COMB, input);
	}
	
	/**
	 * 是否为汉字
	 * @param input
	 * @return
	 */
	public static boolean isChinse(String input){
		return Pattern.matches(EXP_CHINESE, input);
	}
	
	/**
	 * 是否是字母
	 * @param input
	 * @return
	 */
	public static boolean isEnglish(String input){
		return Pattern.matches(EXP_ENGLISH, input);
	}
	
	/**
	 * 是否为标点符号
	 * @param input
	 * @return
	 */
	public static boolean isPunctuation(String input) {
		return Pattern.matches(EXP_PUNCTUATION, input);
	}
	
}
