package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
	
	Button btnTime;
	Button btnDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnTime = (Button) findViewById(R.id.button1);
		btnDate = (Button) findViewById(R.id.button2);
		
		btnTime.setOnClickListener(this);
		btnDate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.button1:
			intent = new Intent("info.fandroid.intent.action.time");
			startActivity(intent);
			break;
		
		case R.id.button2:
			intent = new Intent("info.fandroid.intent.action.date");
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
