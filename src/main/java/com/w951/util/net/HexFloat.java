package com.w951.util.net;

/**
 * 16进制与单精度浮点的转换
 * @author wmli
 *
 */
public class HexFloat {
	public static int getInt(char ch) {// 根据16进制的字符得到对应的int值，a是10，b是11.
		if (ch >= '0' && ch <= '9')
			return ch -= '0';
		if (ch >= 'a' && ch <= 'z')
			ch -= 32;
		if (ch < 'A' || ch > 'Z')
			throw new RuntimeException("参数不合法!");
		return 10 + (ch - 'A');
	}

	public static int[] hexStr2BitArray(String str) {// 把16进制字符串转化成二进制数组
		char chs[] = str.toCharArray();
		int bits[] = new int[chs.length * 4];
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			for (int j = 3; j >= 0; j--) {
				if (((1 << j) & getInt(chs[i])) != 0) {
					bits[index++] = 1;
				} else
					bits[index++] = 0;
			}
		}
		// System.out.println(Arrays.toString(bits));
		return bits;
	}

	public static int parseSign(int ch[]) {// 解析符号位
		return (ch[0] == 1 ? -1 : 1);
	}

	public static int parseExponent(int ch[]) {// 解析指数
		int result = 0;
		for (int i = 1; i <= 8; i++) {
			result += ch[i] * Math.pow(2, 8 - i);
		}
		// System.out.println(result);
		return result;
	}

	public static double parseEnding(int[] ch) {// 解析尾数
		double result = 0;
		for (int i = 9; i <= 31; i++) {
			result += ch[i] * Math.pow(0.5, i - 8);
		}
		// System.out.println(result);
		return result;
	}

	/**
	 * 小端16进制转Float
	 * @param str
	 * @return
	 */
	public static float hexStr2Float(String str) {
		int[] bits = hexStr2BitArray(str);
		int sign = parseSign(bits);
		int e = parseExponent(bits);
		double m = parseEnding(bits);
		// System.out.println("sign="+sign+",e="+e+",m="+m);
		if (e == 0 && m == 0) {
			return 0;
		} else if ((e == 0) && (m != 0)) {
			return (float) (sign * Math.pow(2.0, -126) * m);
		} else if (e >= 1 && e <= 254 && m != 0) {
			return (float) (sign * Math.pow(2.0, e - 127) * (1 + m));
		} else if ((e == 255) && m != 0) {
			if ((sign == 1) && (m == 0.5))
				return Float.NaN;
			else if ((sign == 1) && (m == 0))
				return Float.NEGATIVE_INFINITY;
			else
				return Float.POSITIVE_INFINITY;
		}
		return 0;
	}

	/**
	 * Float转小端16进制
	 * @param f
	 * @return
	 */
	public static String floatToHexStr(float f) {// float转化成16进制很简单
		return Integer.toString(Float.floatToIntBits(f), 16).toUpperCase();
	}
	
	/**
	 * 大端16进制转Float
	 * @param str
	 * @return
	 */
	public static float bHexStr2Float(String str) {
		String hex = "";
		for (int i = 0 ; i < str.length() ; i = i + 2) {
			if (i != 0 && i < str.length()) {
				hex += " ";
			}
			hex += str.substring(i, i + 2);
		}
		String[] hexs = hex.split(" ");
		String temp = "";
		for (int i = hexs.length - 1 ; i > -1 ; i--) {
			temp += hexs[i];
		}
		return hexStr2Float(temp);
	}
	
	/**
	 * Float转大端16进制
	 * @param f
	 * @return
	 */
	public static String bFloatToHexStr(float f) {
		String str = Integer.toString(Float.floatToIntBits(f), 16).toUpperCase();
		String hex = "";
		for (int i = 0 ; i < str.length() ; i = i + 2) {
			if (i != 0 && i < str.length()) {
				hex += " ";
			}
			hex += str.substring(i, i + 2);
		}
		String[] hexs = hex.split(" ");
		String temp = "";
		for (int i = hexs.length - 1 ; i > -1 ; i--) {
			temp += hexs[i];
		}
		return temp;
	}
	
}
