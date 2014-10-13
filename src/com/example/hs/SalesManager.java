package com.example.hs;

import java.lang.reflect.TypeVariable;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 销售经理界面
 * @author jack_sky
 * @time 20141011
 */
public class SalesManager extends BaseActivity{

	private LinearLayout ll_main;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ll_main = new LinearLayout(this);
		LinearLayout.LayoutParams llp_main = new LinearLayout.LayoutParams(screenWidth, screenHeight);
		ll_main.setLayoutParams(llp_main);
		ll_main.setBackgroundResource(R.drawable.background);
		ll_main.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll_main);
		InitLayout();
		setFullScreen(true);
	}
	
	/************************
	 * 函数：初始化布局
	 ************************/
	private void InitLayout(){
		TextView tv_top = new TextView(this);
		LinearLayout.LayoutParams llp_top = new LinearLayout.LayoutParams(screenWidth / 8, screenWidth * 90 / 720);
		tv_top.setText("主页");
		tv_top.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		tv_top.setTextColor(Color.BLACK);
		tv_top.setGravity(Gravity.CENTER);
		llp_top.setMargins(screenWidth * 7 / 16, 0, 0, 0);
		ll_main.addView(tv_top, llp_top);
		
		LinearLayout ll_content = new LinearLayout(this);
		LinearLayout.LayoutParams llp_content = new LinearLayout.LayoutParams(screenWidth, screenWidth * 360 / 720);
		llp_content.setMargins(0, screenWidth * 20 / 720, 0, 0);
		ll_main.addView(ll_content, llp_content);
		
		//新业务申请按钮
		Button im_new = new Button(this);
		im_new.setBackgroundResource(R.drawable.btn);
		SpannableString msg = new SpannableString("新业务\n申请");
		im_new.setText(msg);
		im_new.setTextSize(TypedValue.COMPLEX_UNIT_PX, 35);
		LinearLayout.LayoutParams llp_new = new LinearLayout.LayoutParams(screenWidth * 201 / 720,screenWidth * 200 / 720);
		llp_new.setMargins(screenWidth * 106 / 720, screenWidth * 80 / 720, 0, 0);
		ll_content.addView(im_new, llp_new);
		im_new.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent mIntent = new Intent(getApplicationContext(), NewYeWu.class);
				startActivity(mIntent);
				finish();
			}
		});
		
		//已申请业务按钮
		Button im_have = new Button(this);
		im_have.setBackgroundResource(R.drawable.btn);
		SpannableString msg_have = new SpannableString("已申请\n业务");
		im_have.setText(msg_have);
		im_have.setTextSize(TypedValue.COMPLEX_UNIT_PX, 35);
		LinearLayout.LayoutParams llp_have = new LinearLayout.LayoutParams(screenWidth * 201 / 720,screenWidth * 200 / 720);
		llp_have.setMargins(screenWidth * 106 / 720, screenWidth * 80 / 720, 0, 0);
		ll_content.addView(im_have, llp_have);
	}
}
