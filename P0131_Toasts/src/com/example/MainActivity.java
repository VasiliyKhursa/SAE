package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
	Button button1;
	Button button2;
	Button button3;
	TextView textView;
	
	String TAG = "myLogs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d(TAG, "������ View - ��������");
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		
		textView = (TextView) findViewById(R.id.textView1);
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d(TAG, "������ ����� 1");
				
				try {
					int i = 6/0;
					textView.setText("��������� ������� = " + i);
				} catch (Exception e) {
					// TODO: handle exception
					Log.d(TAG,"������ �� 0 ������", e);
				}
				
				
				//textView.setText("������ ������ 1");
			}
		});
		
		
		button2.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d(TAG, "������ ����� 2");
		textView.setText("������ ������ 2");
	}
	
	public void onClickMy(View v) {
		Log.d(TAG, "������ ����� 3");
		textView.setText("������ ������ 3");
	}
}
