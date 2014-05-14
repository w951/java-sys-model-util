package com.w951.util.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public abstract class CommonAction extends ActionSupport implements RequestAware, SessionAware {
	private static final long serialVersionUID = 7507261764158895174L;
	protected Map<String, Object> jsonData = new HashMap<String, Object>();
	
	public abstract String insert() throws Exception;
	public abstract String delete() throws Exception;
	public abstract String update() throws Exception;
	public abstract String query() throws Exception;
	
	public String getAdminPath() {
		return System.getProperty("systemPath");
	}
}
