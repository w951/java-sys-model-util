package com.w951.util.interceptor;

import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.StrutsStatics;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.w951.util.bean.CookieUtil;
import com.w951.util.dto.User;
import com.w951.util.net.RequestHtml;

public class PermissionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -3434437006770916507L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
		response.setContentType("text/html;charset=UTF-8");
		String requestURI = request.getRequestURI();
		
		Cookie cookie = CookieUtil.getCookieByName(request, "loginInfo");
		if (cookie == null) {
			response.getWriter().print("<script>alert('用户认证失效，请重新登录');</script>");
			return null;
		}
		String[] loginInfo = cookie.getValue().split(",");
		
		// 重新保存至cookie
		String cookieName = "loginInfo";
		String cookieValue = loginInfo[0] + "," + loginInfo[1];
		int cookieMaxAge = 60 * 30; // 保存30分钟
		CookieUtil.addCookie(response, cookieName, cookieValue, cookieMaxAge);
		
		Properties properties = PropertiesLoaderUtils.loadAllProperties("system.properties");
		String permissionUrl = properties.get("system.permissionUrl").toString();
		
		String result = null;
		User admin = (User) request.getSession().getAttribute("admin");
		if (admin == null) {
			result = RequestHtml.postHtml(permissionUrl + "permission/Login/action/checkLogin?loginId=" + loginInfo[0] + "&loginPwd=" + loginInfo[1]);
		} else {
			String loginCookie = "loginId=" + loginInfo[0] + ";" + "loginPwd=" + loginInfo[1];
			result = RequestHtml.postHtmlByCookie(permissionUrl + "permission/Login/action/checkPermission?requestURI=" + requestURI, loginCookie);
		}
		
		if (!result.equals("null")) {
			try {
				JSONObject jsonData = JSONObject.fromObject(result);
				if (jsonData.getString("admin") != null) {
					admin = new User();
					admin.setUserName(jsonData.getString("admin"));
					request.getSession().setAttribute("admin", admin);
				} else if (jsonData.getString("msg") != null) {
					response.getWriter().print(jsonData.getString("msg"));
				}
			} catch (Exception e) {
				response.getWriter().print(result);
				return null;
			}
		}
		
		return invocation.invoke();
	}
	
}
