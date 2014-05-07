package com.w951.util.net.test;

import org.junit.Test;

import com.w951.util.net.RequestHtml;

public class RequestHtmlTest {
	
	@Test
	public void testPost() throws Exception {
		System.out.println(RequestHtml.postHtml("http://crm.umacau.com/nocheckmsg/GetData.ashx?cmd=coup&coupno=123456&coups=10&lp=&ly=laiyuan&mobile=15888878321&vdate=1397659590&lptype=1&vcode=79777EFA254C321393B7276A7A7FF52D"));
	}
}
