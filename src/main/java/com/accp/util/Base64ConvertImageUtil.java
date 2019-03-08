package com.accp.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("all")
public class Base64ConvertImageUtil {

	private Base64ConvertImageUtil() {
	}

	/**
	 * 
	 * @title: getImageToBase64
	 * @description: 图片转化成base64字符串
	 * @param imgFileRealPath
	 * @return
	 */
	public static String convertImageToBase64String(String imgFileRealPath) {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFileRealPath);
			data = new byte[in.available()];// 将图片文件转化为字节数组
			in.read(data);
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 
	 * @title: generateImageFromBase64
	 * @description: base64字符串转化成图片
	 * @param imgBase64Str
	 * @param imgFileRealPath
	 */
	public static void generateImageFromBase64(String imgBase64Str,
			String imgFileRealPath) {
		if (imgBase64Str == null)
			return;
		BASE64Decoder decoder = new BASE64Decoder();
		OutputStream out = null;
		try {
			// Base64解码
			byte[] buffer = decoder.decodeBuffer(imgBase64Str);
			for (int i = 0; i < buffer.length; ++i) {
				if (buffer[i] < 0) {
					buffer[i] += 256;
				}
			}
			// 生成jpeg图片
			out = new FileOutputStream(imgFileRealPath);
			out.write(buffer);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	}
}
