package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TwoActivity extends Activity implements View.OnClickListener{

	final String TAG = "lifecycle";
	Button button1; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		Log.d(TAG, "onCreate()  - TwoActivity - Activity создано");
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		
	}
	
	public TwoActivity() {
		Log.d(TAG, "TwoActivity()  - запуск конструктора");
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart()   - TwoActivity - Activity становиться видимым");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart() - TwoActivity - перезапуск Activity");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume()  - TwoActivity - Activity получает фокус (состояние Resumed)");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause()   - TwoActivity - Activity приостановлено (состояние Paused)");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy() - TwoActivity - Activity уничтожено");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop()    - TwoActivity - Activity остановлено (состояние Stopped)");
	}	
	
	
	public void onClick(View v) {
		Intent intent = new Intent(this, ThreeActivity.class);
		startActivity(intent);	
	}
}
