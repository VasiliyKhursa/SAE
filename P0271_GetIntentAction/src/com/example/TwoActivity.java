package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		/*ѕолучаем Intent, который запустил данное Activity*/
		Intent intent = getIntent();
		/*„итаем параметр Action*/
		String action = intent.getAction();
		
		String format = "", textInfo ="";
		
		// выбираем какой Action был выполнен
		if (action.equals("info.fandroid.intent.action.time")){
			format = "HH:mm:ss";
			textInfo = "Time: ";
		}
		else if (action.equals("info.fandroid.intent.action.date")) {
			format = "dd:MM:yyyy";
			textInfo = "Date: ";
		}
		
		SimpleDateFormat sdt = new SimpleDateFormat(format, Locale.UK);
		String dateTime = sdt.format(new Date(System.currentTimeMillis()));
		
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(textInfo + dateTime);
	}
}
