package com.example.p0301_requestcode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends Activity implements View.OnClickListener{
	Button btn_red;
	Button btn_green;
	Button btn_blue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color);
		
		btn_red = (Button) findViewById(R.id.btn_red);
		btn_green = (Button) findViewById(R.id.btn_green);
		btn_blue = (Button) findViewById(R.id.btn_blue);
		
		btn_red.setOnClickListener(this);
		btn_green.setOnClickListener(this);
		btn_blue.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btn_red:
			intent.putExtra("color", Color.RED);
			break;
		case R.id.btn_green:
			intent.putExtra("color", Color.GREEN);				
			break;
		case R.id.btn_blue:
			intent.putExtra("color", Color.BLUE);			
			break;
		default:
			break;
		}
		
		// добавляем результат
		setResult(RESULT_OK, intent);
		// закрываем Activity
		finish();
	}
}
