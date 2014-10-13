package com.example.hs;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * 新业务
 * @author jack
 *
 */
public class NewYeWu extends BaseActivity{

	private LinearLayout ll_main;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ll_main = new LinearLayout(this);
		ll_main.setBackgroundResource(R.drawable.background);
		LinearLayout.LayoutParams llp_main = new LinearLayout.LayoutParams(screenWidth, screenHeight);
		ll_main.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll_main);
		InitLayout();
	}
	
	private void InitLayout(){
		TextView tv_top = new TextView(this);
		LinearLayout.LayoutParams llp_top = new LinearLayout.LayoutParams(screenWidth / 8, screenWidth * 90 / 720);
		tv_top.setText("命名");
		tv_top.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		tv_top.setTextColor(Color.BLACK);
		tv_top.setGravity(Gravity.CENTER);
		llp_top.setMargins(screenWidth * 7 / 16, 0, 0, 0);
		ll_main.addView(tv_top, llp_top);
		
		
		LinearLayout ll_content = new LinearLayout(this);
		LinearLayout.LayoutParams llp_content = new LinearLayout.LayoutParams(screenWidth * 500 / 720, screenWidth * 100 / 720);
		llp_content.setMargins(screenWidth * 110 / 720, screenWidth * 400 / 720, 0, 0);
		ll_main.addView(ll_content, llp_content);
		
		TextView tv_name = new TextView(this);
		tv_name.setText("项目名:");
		tv_name.setTextSize(TypedValue.COMPLEX_UNIT_PX, 35);
		tv_name.setTextColor(Color.BLACK);
		tv_name.setGravity(Gravity.CENTER);
		LinearLayout.LayoutParams llp_name = new LinearLayout.LayoutParams(screenWidth * 120 / 720, screenWidth * 90 / 720);
		llp_name.setMargins(0, screenWidth * 5/ 720, 0, 0);
		ll_content.addView(tv_name, llp_name);
		
		EditText ed_name = new EditText(this);
		LinearLayout.LayoutParams llp_ed_name = new LinearLayout.LayoutParams(screenWidth * 380 / 720, screenWidth * 90 / 720);
		llp_ed_name.setMargins(0, screenWidth * 5 / 720, 0, 0);
		ll_content.addView(ed_name, llp_ed_name);
		
		
		Button btn_sure = new Button(this);
		LinearLayout.LayoutParams llp_btn = new LinearLayout.LayoutParams(screenWidth / 2, screenWidth / 6);
		btn_sure.setBackgroundResource(R.drawable.load);
		btn_sure.setText("确定");
		btn_sure.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		btn_sure.setTextColor(Color.BLACK);
		llp_btn.setMargins(screenWidth / 4, screenWidth * 100 / 720, 0, 0);
		ll_main.addView(btn_sure, llp_btn);
		
		btn_sure.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				StartCompleteMsg();
			}
		});
	}
	
	/*******************************
	 * 开始填写信息
	 ******************************/
	private void StartCompleteMsg(){
		ll_main.removeAllViews();
		TextView tv_top = new TextView(this);
		LinearLayout.LayoutParams llp_top = new LinearLayout.LayoutParams(screenWidth * 200 / 720, screenWidth * 90 / 720);
		tv_top.setText("资料填写");
		tv_top.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		tv_top.setTextColor(Color.BLACK);
		tv_top.setGravity(Gravity.CENTER);
		llp_top.setMargins(screenWidth * 260 / 720, 0, 0, 0);
		ll_main.addView(tv_top, llp_top);
		
		ScrollView mScrollView = new ScrollView(this);
		mScrollView.setBackgroundColor(Color.RED);
		LinearLayout.LayoutParams llp_scroll = new LinearLayout.LayoutParams(screenWidth, screenHeight - screenWidth * 210 / 720,1 );
		ListView mListView = new ListView(this);
		mListView.setBackgroundColor(Color.RED);
		mScrollView.addView(mListView);
		ll_main.addView(mScrollView, llp_scroll);
		
		Button btn_sure = new Button(this);
		LinearLayout.LayoutParams llp_btn = new LinearLayout.LayoutParams(screenWidth / 2, screenWidth / 6);
		btn_sure.setBackgroundResource(R.drawable.load);
		btn_sure.setText("确定");
		btn_sure.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		btn_sure.setTextColor(Color.BLACK);
		llp_btn.setMargins(screenWidth / 4, 0, 0, 0);
		ll_main.addView(btn_sure, llp_btn);
		
	}
}
