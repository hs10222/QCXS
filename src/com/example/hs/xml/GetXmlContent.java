package com.example.hs.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.example.hs.questions.Questions;

import android.content.Context;

/**
 * 获取sax解析xml后的数据
 * 
 * @author jack_sky
 * @time 20141014 22:26
 */
public class GetXmlContent {

	private Context mContext;
	private List<Questions> list;
	private InputStream is;
	
	/*************************************
	 * 函数：初始化数据
	 * @param context
	 ************************************/
	public GetXmlContent(Context context) {
		mContext = context;
		list = new ArrayList<Questions>();
	}
	
	/************************************
	 * 函数：获取sax解析后的数据
	 * @return
	 ************************************/
	public List<Questions> getParseData(){
		try {
			XMLReader mReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			XmlContentHandler mHandler = new XmlContentHandler();
			mReader.setContentHandler(mHandler);
			is = mContext.getResources().getAssets().open("Questions.xml");
			mReader.parse(new InputSource(is));
			this.list = mHandler.getParseData();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.list;
	}
}
