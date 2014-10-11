package com.example.hs.log;

import android.util.Log;

/**
 * 统一日志打印接口
 * 
 * @author jack_sky
 * @time 20141011 11;17
 */
public class LogApi {

	public static boolean isLog = true;

	/***********************************************
	 * 函数：打印日志消息
	 * @param TAG --标识位
	 * @param msg --日志信息
	 ***********************************************/
	public static void MSG(String TAG, String msg) {
		if (isLog) {
			Log.i(TAG, msg);
		}
	}

	public static boolean isLog() {
		return isLog;
	}

	public static void setLog(boolean isLog) {
		LogApi.isLog = isLog;
	}

}
