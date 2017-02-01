package com.example.p0301_requestcode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{
	
	final int REQUEST_CODE_COLOR = 1;
	final int REQUEST_CODE_ALIGN = 2;

	Button btn_color;
	Button btn_aligm;
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_color = (Button) findViewById(R.id.btn_color);
		btn_aligm = (Button) findViewById(R.id.btn_alignment);
		textView = (TextView) findViewById(R.id.textView1);
		
		btn_aligm.setOnClickListener(this);
		btn_color.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		if (v.getId() == R.id.btn_color) {
			intent = new Intent(this, ColorActivity.class);
			startActivityForResult(intent, REQUEST_CODE_COLOR);
		}
		else if (v.getId() == R.id.btn_alignment) {
			intent = new Intent(this, AlignActivity.class);
			startActivityForResult(intent, REQUEST_CODE_ALIGN);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.d("MyLogs", "requestCode = " + requestCode + ", resultCode" + resultCode);
		
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case REQUEST_CODE_COLOR:
				int color = data.getIntExtra("color", Color.WHITE);
				textView.setTextColor(color);
				break;
				
			case REQUEST_CODE_ALIGN:
				int gravity = data.getIntExtra("align", Gravity.LEFT);
				textView.setGravity(gravity);
				break;

			default:
				break;
			}
		}
		else {
			Toast.makeText(MainActivity.this, "WrongResault", Toast.LENGTH_SHORT).show();
		}
	}
}
