package com.example;

import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String tmp = "";

		try {
			XmlPullParser xpp = prepareXpp();

			while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
				switch (xpp.getEventType()) {
				// ������ ���������
				case XmlPullParser.START_DOCUMENT:
					Log.d(LOG_TAG, "START_DOCUMENT");
					break;
				// ������ ����
				case XmlPullParser.START_TAG:
					Log.d(LOG_TAG, "START_TAG: name = " + xpp.getName() + ", depth = " + xpp.getDepth()
							+ ", attrCount = " + xpp.getAttributeCount());
					tmp = "";
					for (int i = 0; i < xpp.getAttributeCount(); i++) {
						tmp = tmp + xpp.getAttributeName(i) + " = " + xpp.getAttributeValue(i) + ", ";
					}
					if (!TextUtils.isEmpty(tmp))
						Log.d(LOG_TAG, "Attributes: " + tmp);
					break;
				// ����� ����
				case XmlPullParser.END_TAG:
					Log.d(LOG_TAG, "END_TAG: name = " + xpp.getName());
					break;
				// ���������� ����
				case XmlPullParser.TEXT:
					Log.d(LOG_TAG, "text = " + xpp.getText());
					break;

				default:
					break;
				}
				// ��������� �������
				xpp.next();
			}
			Log.d(LOG_TAG, "END_DOCUMENT");

		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	XmlPullParser prepareXpp() {
		return getResources().getXml(R.xml.data);
	}
	
	XmlPullParser prepareXpp2() throws XmlPullParserException {
		  // �������� �������
		  XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		  // �������� ��������� namespace (�� ��������� ���������)
		  factory.setNamespaceAware(true);
		  // ������� ������
		  XmlPullParser xpp = factory.newPullParser();
		  // ���� ������� �� ���� Reader
		  xpp.setInput(new StringReader(
		      "<data><phone><company>Samsung</company></phone></data>"));
		  return xpp;
		}
}