package com.example;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
	
	Button btnTwoAct;
	Button btn_act3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnTwoAct = (Button) findViewById(R.id.btmActTwo);
		btnTwoAct.setOnClickListener(this);
		
		btn_act3 = (Button) findViewById(R.id.btn_act3);
		btn_act3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		Context context1 = getBaseContext();
		Context context2 = getApplicationContext();
		//Context context3 = getContext();
		Context context4 = this;
		Context context5 = MainActivity.this;
		//Context context6 = getActivity();
		switch (v.getId()) {
		case R.id.btmActTwo:
			intent = new Intent (this, ActivityTwo.class);
			startActivity(intent);
			break;
		case R.id.btn_act3:
			intent = new Intent (this, ThreeActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		
		}
	}

}
