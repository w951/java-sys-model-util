package com.w951.util.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sun.xml.internal.ws.util.UtilException;

/**
 * GET网络请求
 * @author wmli
 *
 */
public class RequestGet {
	/**
	 * 获取JSONObject
	 * @param root 根节点名称
	 * @param address 访问地址
	 * @return
	 * @throws UtilException
	 */
	public static JSONObject getJsonObject(String root, String address) throws UtilException {
		try {
			//创建连接
			HttpURLConnection connection = connection(address);

			// POST请求
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			
			//封装JSONObject
			JSONObject object = JSONObject.fromObject(sb.toString());
			JSONObject jsonObject = JSONObject.fromObject(object.get(root));
			
			// 断开连接
			reader.close();
			connection.disconnect();
			return jsonObject;
		} catch (MalformedURLException e) {
			throw new UtilException("getJsonObject", e);
		} catch (UnsupportedEncodingException e) {
			throw new UtilException("getJsonObject", e);
		} catch (IOException e) {
			throw new UtilException("getJsonObject", e);
		}
	}
	
	/**
	 * 获取JSONObject
	 * @param root 根节点名称
	 * @param address 访问地址
	 * @return
	 * @throws UtilException
	 */
	public static JSONObject getJsonObject(String root, String address, String cookie) throws UtilException {
		try {
			//创建连接
			HttpURLConnection connection = connection(address, cookie);

			// POST请求
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			
			//封装JSONObject
			JSONObject object = JSONObject.fromObject(sb.toString());
			JSONObject jsonObject = JSONObject.fromObject(object.get(root));
			
			// 断开连接
			reader.close();
			connection.disconnect();
			return jsonObject;
		} catch (MalformedURLException e) {
			throw new UtilException("getJsonObject", e);
		} catch (UnsupportedEncodingException e) {
			throw new UtilException("getJsonObject", e);
		} catch (IOException e) {
			throw new UtilException("getJsonObject", e);
		}
	}
	
	/**
	 * 获取JSONArray
	 * @param root 根节点名称
	 * @param address 访问地址
	 * @return
	 * @throws UtilException
	 */
	public static JSONArray getJsonArray(String root, String address) throws UtilException {
		try {
			//创建连接
			HttpURLConnection connection = connection(address);

			// POST请求
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			
			//封装JSONArray
			JSONObject object = JSONObject.fromObject(sb.toString());
			JSONArray jsonArray = JSONArray.fromObject(object.get(root));
			
			// 断开连接
			reader.close();
			connection.disconnect();
			return jsonArray;
		} catch (MalformedURLException e) {
			throw new UtilException("getJsonArray", e);
		} catch (UnsupportedEncodingException e) {
			throw new UtilException("getJsonArray", e);
		} catch (IOException e) {
			throw new UtilException("getJsonArray", e);
		}
	}
	
	/**
	 * 获取JSONArray
	 * @param root 根节点名称
	 * @param address 访问地址
	 * @return
	 * @throws UtilException
	 */
	public static JSONArray getJsonArray(String root, String address, String cookie) throws UtilException {
		try {
			//创建连接
			HttpURLConnection connection = connection(address, cookie);

			// POST请求
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			
			//封装JSONArray
			JSONObject object = JSONObject.fromObject(sb.toString());
			JSONArray jsonArray = JSONArray.fromObject(object.get(root));
			
			// 断开连接
			reader.close();
			connection.disconnect();
			return jsonArray;
		} catch (MalformedURLException e) {
			throw new UtilException("getJsonArray", e);
		} catch (UnsupportedEncodingException e) {
			throw new UtilException("getJsonArray", e);
		} catch (IOException e) {
			throw new UtilException("getJsonArray", e);
		}
	}

	/**
	 * 创建连接
	 * @param address 访问地址
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 */
	public static HttpURLConnection connection(String address) throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(address);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.connect();
		return connection;
	}
	
	/**
	 * 创建带Cookie的连接
	 * @param address
	 * @param cookie
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 */
	public static HttpURLConnection connection(String address, String cookie) throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(address);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("cookie", cookie);
		connection.connect();
		return connection;
	}
	
}
