package com.example.hs.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类
 * 
 * @author jack_sky
 * @time 20141011 22:46
 */
public class Tools {

	/*****************************************************
	 * 函数：将httpconnection获取的inputstream转换成byte[]
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 *****************************************************/
	public static byte[] InputStreamToByte(InputStream is) throws IOException {
		ByteArrayOutputStream mStream = new ByteArrayOutputStream();
		int ch;
		while ((ch = is.read()) != -1) {
			mStream.write(ch);
		}
		byte data[] = mStream.toByteArray();
		mStream.close();
		return data;
	}
	
}
