package com.w951.util.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 继承了Struts的ActionSupport 需要实现RequestAware, SessionAware接口 <br />
 * <br />
 * 内置了处理JSON的Map对象,jsonData
 * 
 * @author wmli
 * 
 */
@Scope("prototype")
public abstract class CommonBaseAction extends ActionSupport implements RequestAware, SessionAware {
	private static final long serialVersionUID = 8282309383152956956L;
	protected Map<String, Object> jsonData = new HashMap<String, Object>();

	public String getAdminPath() {
		return System.getProperty("systemPath");
	}

	// 跨域请求

	protected String jsoncallback;

	protected void jsoncallback(JSONArray result) throws Exception {
		String callback = jsoncallback + "(" + result + ")";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(callback);
	}

	public String getJsoncallback() {
		return jsoncallback;
	}

	public void setJsoncallback(String jsoncallback) {
		this.jsoncallback = jsoncallback;
	}
}
