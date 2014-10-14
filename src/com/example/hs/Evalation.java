package com.example.hs;

import java.util.ArrayList;
import java.util.List;

import com.example.hs.questions.Questions;
import com.example.hs.xml.GetXmlContent;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * 风险评估界面
 * 
 * @author jack_sky
 * @time 20141014 22:38
 */
public class Evalation extends BaseActivity {
	private LinearLayout ll_main;
	private List<Questions> list =new ArrayList<Questions>();
	private GetXmlContent mContent;
	private ScrollView mScrollView;
	private ProgressDialog mDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ll_main = new LinearLayout(this);
		ll_main.setBackgroundResource(R.drawable.background);
		LinearLayout.LayoutParams llp_main = new LinearLayout.LayoutParams(
				screenWidth, screenHeight);
		ll_main.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll_main);
		InitLayout();
		LoadQuestionContent();
	}

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 2) {// 显示
				ShowContent();
			}
		}
	};

	private void LoadQuestionContent(){
		mContent = new GetXmlContent(this);
		list = mContent.getParseData();
		if(list != null && list.size() > 0){
			mHandler.sendEmptyMessage(2);
		}
	}
	private void InitLayout() {
		TextView tv_top = new TextView(this);
		LinearLayout.LayoutParams llp_top = new LinearLayout.LayoutParams(
				screenWidth * 200 / 720, screenWidth * 90 / 720);
		tv_top.setText("风险评估");
		tv_top.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		tv_top.setTextColor(Color.BLACK);
		tv_top.setGravity(Gravity.CENTER);
		llp_top.setMargins(screenWidth * 260 / 720, 0, 0, 0);
		ll_main.addView(tv_top, llp_top);
		
		 mScrollView = new ScrollView(this);
		mScrollView.setVisibility(View.GONE);
		mScrollView.setBackgroundColor(Color.RED);
		LinearLayout.LayoutParams llp_scroll = new LinearLayout.LayoutParams(
				screenWidth, screenHeight - screenWidth * 210 / 720, 1);
		ListView mListView = new ListView(this);
		mScrollView.addView(mListView);
		ll_main.addView(mScrollView, llp_scroll);
		
		Button btn_sure = new Button(this);
		LinearLayout.LayoutParams llp_btn = new LinearLayout.LayoutParams(
				screenWidth / 2, screenWidth / 6);
		btn_sure.setBackgroundResource(R.drawable.load);
		btn_sure.setText("确定");
		btn_sure.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
		btn_sure.setTextColor(Color.BLACK);
		llp_btn.setMargins(screenWidth / 4, 0, 0, 0);
		ll_main.addView(btn_sure, llp_btn);
		
		mDialog = new ProgressDialog(this);
		mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		LinearLayout.LayoutParams llp_pro = new LinearLayout.LayoutParams(screenWidth * 100 / 720, screenWidth * 100 / 720);
		mDialog.show();
		mDialog.setCanceledOnTouchOutside(false);
	}

	private void ShowContent() {
//		mDialog.dismiss();
		mScrollView.setVisibility(View.VISIBLE);
	}
}
