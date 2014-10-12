package com.example.hs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 与服务器数据交互，http发送和请求数据工具类
 * 
 * @author jack_sky
 * @time 20140428 1:06
 */
public class HttpUtil {
	// get请求，有文件长度大小限制
	/************************************************
	 * 函数:get请求方式
	 * @param path-- url路径
	 * @return true请求成功 false请求失败
	 ************************************************/
	public static String getRequest(String path) {
		String result = "error";
		try {
			URL url = new URL(path);
			// 打开url的连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置请求方式为get
			conn.setRequestMethod("GET");
			// 设置请求超时时间为5秒
			conn.setReadTimeout(5000);
			// 请求成功返回true
			if (conn.getResponseCode() == 200) {
				InputStream mIs = conn.getInputStream();
				byte[] data = Tools.InputStreamToByte(mIs);
				result = new String(data,"UTF-8");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/************************************************************************
	 * 
	 * 函数：post请求方式
	 * 
	 * @param path
	 *            -- 请求路径
	 * @param map
	 *            -- 请求参数
	 * @return true请求成功 ， false请求失败
	 ************************************************************************/
	public static boolean postRequest(String path, Map<String, String> map) {
		// 拼接URL
		StringBuilder builder = new StringBuilder();
		if (map != null && !map.isEmpty()) {
			for (Map.Entry<String, String> param : map.entrySet()) {
				try {
					builder.append(param.getKey())
							.append('=')
							.append(URLEncoder.encode(param.getValue(), "utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			builder.deleteCharAt(builder.length() - 1);
		}
		// 下面的Content-Length: 是这个URL的二进制数据长度
		byte b[] = builder.toString().getBytes();
		try {
			URL url = new URL(path);
			// 打开连接
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 设置post请求方式
			con.setRequestMethod("POST");
			con.setReadTimeout(2 * 1000);
			con.setDoOutput(true);// 打开向外输出
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");// 内容类型
			con.setRequestProperty("Content-Length", String.valueOf(b.length));// 长度
			// 获取输出流
			OutputStream outStream = con.getOutputStream();
			outStream.write(b);// 写入数据
			outStream.flush();// 刷新内存
			outStream.close();
			// 请求是否成功
			if (con.getResponseCode() == 200) {
				return true;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}