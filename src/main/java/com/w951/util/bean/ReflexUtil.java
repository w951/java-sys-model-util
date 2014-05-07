package com.w951.util.bean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class ReflexUtil {
	/**
	 * 获取对象属性值
	 * 
	 * @param obj 需要获取数据的对象
	 * @param propertyName 对象属性名称
	 * @return
	 */
	public static Object getValue(Object obj, String propertyName) {
		try {
			return PropertyUtils.getSimpleProperty(obj, propertyName);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 设置对象属性值
	 * 
	 * @param obj
	 * @param propertyName
	 * @param propertyValue
	 */
	public static void setValue(Object obj, String propertyName,
			Object propertyValue) {
		try {
			PropertyUtils.setProperty(obj, propertyName, propertyValue);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取对象属性类型 <br />
	 * 类型格式如 <br />
	 * java.lang.Long <br />
	 * java.lang.Double <br />
	 * java.lang.Integer <br />
	 * java.util.Date
	 * 
	 * @param obj 需要获取数据的对象
	 * @param propertyName 属性名称
	 * @return
	 */
	public static String getPropertyType(Object obj, String propertyName) {
		try {
			PropertyDescriptor pd = PropertyUtils.getPropertyDescriptor(obj,
					propertyName);
			return pd.getPropertyType().getName();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取对象属性数组
	 * 
	 * @param obj 需要获取数据的对象
	 * @return
	 */
	public static String[] getPropertyTypes(Object obj) {
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj
				.getClass());
		String[] pts = new String[pds.length];
		for (int i = 0; i < pds.length; i++) {
			pts[i] = pds[i].getName();
		}
		return pts;
	}

}
