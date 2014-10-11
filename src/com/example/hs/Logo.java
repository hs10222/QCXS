package com.example.hs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

/**
 * 启动界面
 * 
 * @author jack_sky
 * @time 20140928 20140930 10:57
 * 
 */
public class Logo extends BaseActivity {

	private LinearLayout ll_main;
	private int niFame;
	private MyThread mThread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ll_main = new LinearLayout(this);
		ll_main.setBackgroundResource(R.drawable.logo);
		setContentView(ll_main);
		setFullScreen(true);
		startNextView();
	}

	/*****************************
	 * 函数：跳转到下一个界面
	 *****************************/
	private void startNextView() {
		mThread = new MyThread();
		mThread.start();
	}

	/*************************************
	 * 启动动画线程
	 * @author jack_sky
	 * @time 20141011 11:23
	 ************************************/
	private class MyThread extends Thread {
		@Override
		public void run() {
			while (niFame <= 6) {
				mHandler.sendEmptyMessage(niFame);
				niFame++;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/********************************
	 * 消息：处理不同的请求
	 *******************************/
	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what < 6) {
				ll_main.setBackgroundResource(R.drawable.logo);
			} else {
				Intent intent = new Intent(getApplicationContext(), Load.class);
				startActivity(intent);
				finish();
			}
		}
	};
}
