package com.example;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

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
		
		OnClickListener onClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				switch (v.getId()) {
					case R.id.button1:
						textView.setText(R.string.str1);
						break;
						
					case R.id.button2:
						textView.setText(R.string.str2);
						break;
						
					case R.id.button3:
						textView.setText(R.string.str3);
						break;
						
					case R.id.textView1:
						if (textView.getCurrentTextColor() == Color.RED){
							textView.setTextColor(Color.GREEN);
						}
						else {
							textView.setTextColor(Color.RED);
						}
						break;
	
				default:
					break;
				}	
				
			}
		};
		
		button1.setOnClickListener(onClickListener);
		button2.setOnClickListener(onClickListener);
		button3.setOnClickListener(onClickListener);
		// разрешаем нажатие на текст
		textView.setClickable(true);
		textView.setOnClickListener(onClickListener);
	}
}
