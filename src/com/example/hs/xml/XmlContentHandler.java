package com.example.hs.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.hs.log.LogApi;
import com.example.hs.questions.Questions;
/**
 * 解析本地调查问卷
 * @author jack
 * @time 20141014 22:13
 */
public class XmlContentHandler extends DefaultHandler{
	private Questions QS;
	private List<Questions> list;
	
	private boolean in_QS = false;
	private boolean in_QSName = false;
	private boolean in_A = false;
	private boolean in_B = false;
	private boolean in_C = false;
	private boolean in_D = false;
	private boolean in_E = false;
	
	private StringBuffer buf = new StringBuffer();
	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<Questions>();
	}

	public List<Questions> getParseData(){
		return this.list;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("QS".equals(localName)){
			this.QS = new Questions();
			this.in_QS = true;
		}
		else if("QS_Name".equals(localName)){
			this.in_QSName = true;
		}
		else if("AS_A".equals(localName)){
			this.in_A = true;
		}
		else if("AS_B".equals(localName)){
			this.in_B = true;
		}
		else if("AS_C".equals(localName)){
			this.in_C = true;
		}
		else if("AS_D".equals(localName)){
			this.in_D = true;
		}
		else if("AS_E".equals(localName)){
			this.in_E = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("QS".equals(localName)){
			this.list.add(QS);
			this.in_QS = false;
		}else{
			if(this.in_QS){
				if("QS_Name".equals(localName)){
					this.QS.setQS_Name(this.buf.toString());
					LogApi.MSG("XmlContentHandler", "Name------------->>>"+this.buf.toString());
					this.buf.setLength(0);
					this.in_QSName = false;
				}
				else if("AS_A".equals(localName)){
					this.QS.setAS_A(this.buf.toString());
					LogApi.MSG("XmlContentHandler", "A------------->>>"+this.buf.toString());
					this.buf.setLength(0);
					this.in_A = false;
				}
				else if("AS_B".equals(localName)){
					this.QS.setAS_B(this.buf.toString());
					this.buf.setLength(0);
					this.in_B = false;
				}
				else if("AS_C".equals(localName)){
					this.QS.setAS_C(this.buf.toString());
					this.buf.setLength(0);
					this.in_C = false;
				}
				else if("AS_D".equals(localName)){
					this.QS.setAS_D(this.buf.toString());
					this.buf.setLength(0);
					this.in_D = false;
				}
				else if("AS_E".equals(localName)){
					this.QS.setAS_E(this.buf.toString());
					this.buf.setLength(0);
					this.in_E = false;
				}
			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(this.in_QS){
			buf.append(ch, start, length);
		}
	}
	
}
