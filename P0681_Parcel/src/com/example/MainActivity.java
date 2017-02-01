package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";
	Parcel p;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		writeParcel();
		readParcel();
	}

	void writeParcel() {
		p = Parcel.obtain();

		byte b = 1;
		int i = 2;
		long l = 3;
		float f = 4;
		double d = 5;
		String s = "abcdefgh";

		logWriteInfo("before writing");
		p.writeByte(b);
		logWriteInfo("byte");
		p.writeInt(i);
		logWriteInfo("int");
		p.writeLong(l);
		logWriteInfo("long");
		p.writeFloat(f);
		logWriteInfo("float");
		p.writeDouble(d);
		logWriteInfo("double");
		p.writeString(s);
		logWriteInfo("String");
	}

	void logWriteInfo(String txt) {
		Log.d(LOG_TAG, txt + ": " + "dataSize = " + p.dataSize());
	}

	void readParcel() {
	}

	void logReadInfo(String txt) {
	}

}