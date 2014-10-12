package com.example.hs;

import com.example.hs.log.LogApi;
import com.example.hs.utils.HttpUtil;
import com.example.hs.utils.UrlUtils;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * 登录界面
 * 
 * @author jack_sky
 * @time 20140930 15:59
 */
public class Load extends BaseActivity {

	private LinearLayout ll_main;
	private LinearLayout ll_center;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ll_main = new LinearLayout(this);
		ll_main.setOrientation(LinearLayout.VERTICAL);
		ll_main.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		ll_main.setBackgroundResource(R.drawable.logo);
		setFullScreen(true);
		InitLayout();
		setContentView(ll_main);
	}

	/*************************
	 * 函数：初始化布局
	 *************************/
	private void InitLayout() {
		ll_center = new LinearLayout(this);
		ll_center.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams llp_center = new LinearLayout.LayoutParams(
				screenWidth * 500 / 720, screenWidth * 500 / 720);
		llp_center.setMargins(screenWidth * 110 / 720,
				(screenHeight - screenWidth * 500 / 720) / 2, 0, 0);
		ll_center.setLayoutParams(llp_center);
		ll_main.addView(ll_center);

		InitUserNameLayout();
		InitUserPassWordLayout();
		InitLoadLayout();
	}

	/**********************************
	 * 函数：初始化用户名布局
	 ***********************************/
	private void InitUserNameLayout() {
		// 用户名布局
		LinearLayout ll_user = new LinearLayout(this);
		LinearLayout.LayoutParams llp_user = new LinearLayout.LayoutParams(
				screenWidth * 500 / 720, screenWidth * 150 / 720);
		ll_center.addView(ll_user, llp_user);

		// 用户名
		TextView tv_user = new TextView(this);
		tv_user.setGravity(Gravity.LEFT);
		tv_user.setText(R.string.name);
		tv_user.setTextColor(Color.WHITE);
		tv_user.setTextSize(TypedValue.COMPLEX_UNIT_PX, 35);
		LinearLayout.LayoutParams llp_tv_user = new LinearLayout.LayoutParams(
				screenWidth * 120 / 720, screenWidth * 150 / 720);
		ll_user.addView(tv_user, llp_tv_user);
		// 用户名输入框
		EditText ed_user = new EditText(this);
		ed_user.setSingleLine(true);
		ed_user.setGravity(Gravity.LEFT);
		LinearLayout.LayoutParams llp_ed_user = new LinearLayout.LayoutParams(
				screenWidth * 380 / 720, screenWidth * 115 / 720);
		ll_user.addView(ed_user, llp_ed_user);
	}

	/*************************************
	 * 函数：初始化用户密码布局
	 *************************************/
	private void InitUserPassWordLayout() {
		// 密码布局
		LinearLayout ll_pass = new LinearLayout(this);
		LinearLayout.LayoutParams llp_pass = new LinearLayout.LayoutParams(
				screenWidth * 500 / 720, screenWidth * 150 / 720);
		ll_center.addView(ll_pass, llp_pass);

		// 密码
		TextView tv_pass = new TextView(this);
		tv_pass.setGravity(Gravity.LEFT);
		tv_pass.setText(R.string.pass);
		tv_pass.setTextColor(Color.WHITE);
		tv_pass.setTextSize(TypedValue.COMPLEX_UNIT_PX, 35);
		LinearLayout.LayoutParams llp_tv_pass = new LinearLayout.LayoutParams(
				screenWidth * 120 / 720, screenWidth * 150 / 720);
		ll_pass.addView(tv_pass, llp_tv_pass);
		// 密码输入框
		EditText ed_pass = new EditText(this);
		ed_pass.setSingleLine(true);
		ed_pass.setInputType(InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		ed_pass.setGravity(Gravity.LEFT);
		LinearLayout.LayoutParams llp_ed_pass = new LinearLayout.LayoutParams(
				screenWidth * 380 / 720, screenWidth * 115 / 720);
		ll_pass.addView(ed_pass, llp_ed_pass);
	}

	/****************************
	 * 函数：初始化登录按钮布局
	 ***************************/
	private void InitLoadLayout() {

		Button btn_load = new Button(this);
		btn_load.setText("登录");
		btn_load.setTextColor(Color.BLACK);
		btn_load.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		btn_load.setGravity(Gravity.CENTER);
		btn_load.setBackgroundResource(R.drawable.load);
		LinearLayout.LayoutParams llp_load = new LinearLayout.LayoutParams(
				screenWidth * 400 / 720, screenWidth * 120 / 720);
		llp_load.setMargins(screenWidth * 50 / 720, screenWidth * 50 / 720, 0,
				0);
		ll_center.addView(btn_load, llp_load);

//		btn_load.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				LogApi.MSG("sys",
//						"data---" + HttpUtil.getRequest(UrlUtils.BASE_PATH));
//			}
//		});
	}
}
