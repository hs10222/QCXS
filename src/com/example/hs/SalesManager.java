package com.example.hs;

import android.os.Bundle;
import android.widget.LinearLayout;
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
		setContentView(ll_main);
		setFullScreen(true);
	}
}
