package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ThreeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
		Log.d(TAG, "onCreate()  - ThreeActivity - Activity создано");
	}
	

	final String TAG = "lifecycle";
	Button button1; 
	
	public ThreeActivity() {
		Log.d(TAG, "ThreeActivity()  - запуск конструктора");
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart()   - ThreeActivity - Activity становиться видимым");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart() - ThreeActivity - перезапуск Activity");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume()  - ThreeActivity - Activity получает фокус (состояние Resumed)");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause()   - ThreeActivity - Activity приостановлено (состояние Paused)");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy() - ThreeActivity - Activity уничтожено");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop()    - ThreeActivity - Activity остановлено (состояние Stopped)");
	}	
	
	
}
