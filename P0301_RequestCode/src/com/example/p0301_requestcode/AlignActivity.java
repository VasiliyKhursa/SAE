package com.example.p0301_requestcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends Activity implements View.OnClickListener{

	Button btn_left;
	Button btn_center;
	Button btn_right;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_align);
		
		btn_left = (Button) findViewById(R.id.btn_left);
		btn_right = (Button) findViewById(R.id.btn_right);
		btn_center = (Button) findViewById(R.id.btn_center);
		
		btn_left.setOnClickListener(this);
		btn_center.setOnClickListener(this);
		btn_right.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btn_left:
			intent.putExtra("align", Gravity.LEFT);
			break;
		
		case R.id.btn_center:
			intent.putExtra("align", Gravity.CENTER);		
			break;
		
		case R.id.btn_right:
			intent.putExtra("align", Gravity.RIGHT);
			break;
			
		default:
			break;
		}
		
		setResult(RESULT_OK, intent);

		finish();
	}
}
