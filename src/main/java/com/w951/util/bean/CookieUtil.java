package com.w951.util.bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	/**
	 * 设置cookie
	 * 
	 * @param response
	 * @param name cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期 以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	/**
	 * 删除cookie
	 * @param response
	 * @param name
	 */
	public static void removeCookie(HttpServletResponse response, String name) {
		Cookie cookie=new Cookie(name, null); 
		cookie.setMaxAge(0); //立即删除型
		cookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
		response.addCookie(cookie); //重新写入，将覆盖之前的
	}
	
	/**
	 * 删除全部cookies
	 * @param request
	 * @param response
	 */
	public static void removeAllCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}

	/**
	 * 根据名字获取cookie
	 * 
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面
	 * 
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

}
