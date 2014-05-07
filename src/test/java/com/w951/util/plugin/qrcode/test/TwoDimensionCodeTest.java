package com.w951.util.plugin.qrcode.test;

import org.junit.Test;

import com.w951.util.plugin.qrcode.TwoDimensionCode;

public class TwoDimensionCodeTest {
	
	@Test
	public void testEncoderQRCode() {
		String imgPath = "d:/Michael_QRCode.png";
		String encoderContent = "Hello 大大、小小,welcome to QRCode!" + "\nMyblog [ http://sjsky.iteye.com ]" + "\nEMail [ sjsky007@gmail.com ]";
		TwoDimensionCode handler = new TwoDimensionCode();
		// 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大（存储的信息越多，需要的尺寸越大）
		handler.encoderQRCode(encoderContent, imgPath, "png", 8);
	}
	
//	@Test
	public void testDecoderQRCode() {
		String imgPath = "d:/Michael_QRCode.png";
		TwoDimensionCode handler = new TwoDimensionCode();
		String decoderContent = handler.decoderQRCode(imgPath);
		System.out.println(decoderContent);
	}
	
}
