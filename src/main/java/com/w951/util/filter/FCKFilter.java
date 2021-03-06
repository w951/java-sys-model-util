package com.w951.util.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class FCKFilter extends StrutsPrepareAndExecuteFilter {
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String URI = request.getRequestURI();
		
		// 解决CKFinder浏览器路径兼容
		
		if (URI.indexOf("ckfinder") != -1) {
			URI = URI.substring(URI.indexOf("/ckfinder"));
			request.getRequestDispatcher(URI).forward(req, res);
			return;
		}
		
		String[] uriArray = URI.split("/ckfinder/core/connector/java/*/");
		int arrayLen = uriArray.length;
		if (arrayLen >= 2) {
			chain.doFilter(req, res);
		} else {
			super.doFilter(req, res, chain);
		}
	}
}
