package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

	Button button1_time;
	Button button2_date;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1_time = (Button) findViewById(R.id.button1_time);
		button2_date = (Button) findViewById(R.id.button2_date);
		
		button1_time.setOnClickListener(this);
		button2_date.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		//Intent intent2 =new Intent
		
		switch(v.getId()) {
		case R.id.button1_time:
			intent = new Intent("info.fandroid.intent.action.time");
			startActivity(intent);
			break;
		case R.id.button2_date:
			intent = new Intent("info.fandroid.intent.action.date");
			startActivity(intent);
			break;
		default:
			break;
		}
		
	}
}
