package com.example.hs.adaper;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ScrollAdapter extends BaseAdapter{

	private List<String> mList;
	public ScrollAdapter(List<String> list) {
		mList = list;
	}
	@Override
	public int getCount() {
		if(mList != null){
			return mList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		if(mList != null){
			return mList.get(arg0);
		}
		return "null";
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	class Holder{
		
	}
}
