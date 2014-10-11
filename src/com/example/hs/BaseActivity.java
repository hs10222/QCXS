package com.example.hs;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
/**
 * 基础Activity，提供给子类继承使用
 * @author jack_sky
 * @time 20140930 10:56
 *
 */
public class BaseActivity extends Activity {
	public int screenHeight;
	public int screenWidth;
	public float scale_pixel;
	protected BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			finish();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		 requestWindowFeature(Window.FEATURE_NO_TITLE);
//	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
//	                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.ID_ANDROID_CONTENT);
		IntentFilter filter = new IntentFilter();
		filter.addAction("ExitApp");
		this.registerReceiver(broadcastReceiver, filter);
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		screenHeight = metric.heightPixels; // ��Ļ��ȣ����أ�
		screenWidth = metric.widthPixels; // ��Ļ�߶ȣ����أ�
		scale_pixel = metric.density; // ��Ļ�ܶ�
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onDestroy() {
		this.unregisterReceiver(broadcastReceiver);
		super.onResume();
	}

	/*******************
	 * �������˳�app
	 *******************/
	public void close() {
		Intent intent = new Intent();
		intent.setAction("ExitApp");
		this.sendBroadcast(intent);
		super.finish();
	}

	/***************************************
	 * �����������Ƿ�ȫ��
	 * 
	 * @param isFull
	 ****************************************/
	public void setFullScreen(boolean isFull) {
		if (isFull) {
			// ȫ����ʾ
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}
	}
}
