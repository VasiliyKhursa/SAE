package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
	
	final String TAG = "lifecycle";
	Button button1; 
	
	public MainActivity() {
		Log.d(TAG, "MainActivity()  - запуск конструктора");
	}

	/*Вызываеться при создании Activity*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		Log.d(TAG, "onCreate()  - MainActivity - Activity создано");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart()   - MainActivity - Activity становиться видимым");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart() - MainActivity - перезапуск Activity");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume()  - MainActivity - Activity получает фокус (состояние Resumed)");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause()   - MainActivity - Activity приостановлено (состояние Paused)");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy() - MainActivity - Activity уничтожено");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop()    - MainActivity - Activity остановлено (состояние Stopped)");
	}
	
	
	public void onClick(View v) {
		
	}

}
