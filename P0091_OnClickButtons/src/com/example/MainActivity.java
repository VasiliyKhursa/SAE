package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SimpleAdapter.ViewBinder;

public class MainActivity extends Activity implements View.OnClickListener{
	Button button1;
	Button button2;
	Button button3;
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		
		textView = (TextView) findViewById(R.id.textView1);
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textView.setText("Нажата кнопка 1");
			}
		});
		
		
		button2.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		textView.setText("Нажата кнопка 2");
	}
	
	public void onClickMy(View v) {
		textView.setText("Нажата кнопка 3");
	}
}
