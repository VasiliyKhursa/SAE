package com.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

	Button btn_web;
	Button btn_map;
	Button btn_call;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_call = (Button) findViewById(R.id.btn_call);
		btn_map = (Button) findViewById(R.id.btn_map);
		btn_web = (Button) findViewById(R.id.btn_web);
		
		btn_call.setOnClickListener(this);
		btn_map.setOnClickListener(this);
		btn_web.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent intent;
		
		switch (v.getId()) {
		case R.id.btn_web:
			//ACTION_VIEW - означает, что мы хотим просмотреть что-либо
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.сom"));
			startActivity(intent);
			break;
			
		case R.id.btn_map:
			intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("geo:-0.45609946,-90.26607513"));
			startActivity(intent);
			break;
			
		case R.id.btn_call:
			//ACTION_DIAL - открывает звонилку
			intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:0634257125"));
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
}
