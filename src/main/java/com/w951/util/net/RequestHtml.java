package com.w951.util.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;

/**
 * Java发送Http请求，解析html返回
 * @author lusifer
 * 
 */
public class RequestHtml {
	/**
	 * POST请求获取HTML
	 * @param strUrl	要访问的地址
	 * @return
	 * @throws IOException
	 */
	public static String postHtml(String strUrl) throws Exception {
		StringBuffer sb = new StringBuffer();
		Parser parser = new Parser((HttpURLConnection) (new URL(strUrl)).openConnection());
		for (NodeIterator i = parser.elements(); i.hasMoreNodes();) {
			Node node = i.nextNode();
			sb.append(node.toHtml());
		}
		return sb.toString();
	}
	
	public static String postHtmlByCookie(String strUrl, String cookie) throws Exception {
		URL url = new URL(strUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("cookie", cookie);
		
		StringBuffer sb = new StringBuffer();
		Parser parser = new Parser(connection);
		for (NodeIterator i = parser.elements(); i.hasMoreNodes();) {
			Node node = i.nextNode();
			sb.append(node.toHtml());
		}
		return sb.toString();
	}
	
	/**
	 * POST请求获取HTML
	 * 自定义编码
	 * @param strUrl	要访问的地址
	 * @param encoding	编码方式
	 * @return
	 * @throws Exception
	 */
	public static String postHtmlByEncoding(String strUrl, String encoding) throws Exception {
		StringBuffer sb = new StringBuffer();
		Parser parser = new Parser((HttpURLConnection) (new URL(strUrl)).openConnection());
		parser.setEncoding(encoding);
		for (NodeIterator i = parser.elements(); i.hasMoreNodes();) {
			Node node = i.nextNode();
			sb.append(node.toHtml());
		}
		return sb.toString();
	}
	
	/**
	 * POST请求获取网页纯文本
	 * @param strUrl	要访问的地址
	 * @return
	 * @throws Exception
	 */
	public static String postHtmlText(String strUrl) throws Exception {
		Parser parser = new Parser((HttpURLConnection) (new URL(strUrl)).openConnection());
		TextExtractingVisitor visitor = new TextExtractingVisitor();
		parser.visitAllNodesWith(visitor);
		String textInPage = visitor.getExtractedText();
		return textInPage;
	}
	
	/**
	 * POST请求获取网页纯文本
	 * 自定义编码
	 * @param strUrl	要访问的地址
	 * @param encoding	编码方式
	 * @return
	 * @throws Exception
	 */
	public static String postHtmlTextByEncoding(String strUrl, String encoding) throws Exception {
		Parser parser = new Parser((HttpURLConnection) (new URL(strUrl)).openConnection());
		parser.setEncoding(encoding);
		TextExtractingVisitor visitor = new TextExtractingVisitor();
		parser.visitAllNodesWith(visitor);
		String textInPage = visitor.getExtractedText();
		return textInPage;
	}
	
	/**
	 * POST请求获取网页纯文本
	 * @param strUrl	要访问的地址
	 * @param filter	过滤条件
	 * @return
	 */
	public static String postHtmlTextFilter(String strUrl, NodeFilter filter) throws Exception {
		StringBuffer sb = new StringBuffer();
		Parser parser = new Parser((HttpURLConnection) (new URL(strUrl)).openConnection());
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		
		if (nodes != null) {
			for (int i = 0; i < nodes.size(); i++) {
				Node textnode = (Node) nodes.elementAt(i);
				sb.append(textnode.toPlainTextString());
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * POST请求获取网页纯文本
	 * 自定义编码
	 * @param strUrl	要访问的地址
	 * @param filter	过滤条件
	 * @param encoding	编码方式
	 * @return
	 * @throws Exception
	 */
	public static String postHtmlTextFilterByEncoding(String strUrl, NodeFilter filter, String encoding) throws Exception {
		StringBuffer sb = new StringBuffer();
		Parser parser = new Parser((HttpURLConnection) (new URL(strUrl)).openConnection());
		parser.setEncoding(encoding);
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		
		if (nodes != null) {
			for (int i = 0; i < nodes.size(); i++) {
				Node textnode = (Node) nodes.elementAt(i);
				sb.append(textnode.toPlainTextString());
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 解析纯HTML文件
	 * @param html
	 * @param filter
	 * @return
	 * @throws ParserException
	 */
	public static String parserHtml(String html, NodeFilter filter) throws ParserException {
		StringBuffer sb = new StringBuffer();
		Parser parser = new Parser(html);
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		
		if (nodes != null) {
			for (int i = 0; i < nodes.size(); i++) {
				Node textnode = (Node) nodes.elementAt(i);
				sb.append(textnode.toPlainTextString() + "\r\n");
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
//		//POST请求获取网页纯文本 - 过滤功能, 自定义编码
//		try {
//			NodeFilter filter = new HasAttributeFilter("div");
//			System.out.println(NetHtml.postHtmlTextFilterByEncoding("http://www.xunlei.com", filter, "UTF-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		//POST请求获取网页纯文本 - 自定义编码
//		try {
//			System.out.println(NetHtml.postHtmlTextByEncoding("http://www.xunlei.com", "UTF-8"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		//POST请求获取HTML - 自定义编码
//		try {
//			String result = NetHtml.postHtmlByEncoding("http://www.xunlei.com", "UTF-8");
//			System.out.println(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		//POST请求获取HTML
//		try {
//			String result = NetHtml.postHtml("http://www.sina.com.cn");
//			System.out.println(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		//POST请求获取网页纯文本
//		try {
//			System.out.println(NetHtml.postHtmlText("http://www.xunlei.com"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		//POST请求获取网页纯文本 - 过滤功能
//		try {
//			NodeFilter filter = new HasAttributeFilter("class", "exponent");
//			System.out.println(NetHtml.postHtmlTextFilter("http://tw.money.yahoo.com/currency_exc_result?amt=1&from=USD&to=CNY", filter));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
