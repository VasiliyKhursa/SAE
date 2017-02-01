package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends Activity {
	
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		textView = (TextView) findViewById(R.id.textView1);
		
		// �������� intent, ������� �������� Activity
		Intent intent = getIntent();
		
		// �������� ������������� ������ � intent-�
		String name = intent.getStringExtra("name");
		
		textView.setText(name);
	}
}
