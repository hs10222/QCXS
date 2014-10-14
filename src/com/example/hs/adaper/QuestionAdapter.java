package com.example.hs.adaper;

import java.util.List;

import com.example.hs.questions.Questions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 调查问卷listview数据适配器
 * @author jack_sky
 * @time 20141014 22:53
 */
public class QuestionAdapter extends BaseAdapter{

	private List<Questions> mList;
	public QuestionAdapter(List<Questions> list) {
		mList = list;
	}
	@Override
	public int getCount() {
		if(mList.size() > 0){
			return mList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		if(mList.size() > 0){
			mList.get(arg0);
		}
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		return null;
	}

	class Holder{
		TextView tv_qs_name;
	}
}
