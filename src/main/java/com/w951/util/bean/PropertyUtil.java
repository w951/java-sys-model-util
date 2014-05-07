package com.w951.util.bean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	private static PropertyUtil instance = new PropertyUtil();
	private String path;

	public static PropertyUtil getInstance() {
		return instance;
	}

	private PropertyUtil() {
		path = this.getClass().getResource("/").getPath();
	}

	/**
	 * 加载properties文件
	 * 
	 * @param fileName 文件名，只需要输入文件名即可，不需要加后缀
	 * @return Properties
	 * @throws IOException 
	 */
	public Properties loadProperties(String fileName) {
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					new File(path + fileName + ".properties")));
			Properties pro = new Properties();
			pro.load(in);
			return pro;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
