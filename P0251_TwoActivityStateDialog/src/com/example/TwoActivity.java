package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class TwoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		Log.d(TAG, "onCreate()  - TwoActivity - Activity �������");
	}

	final String TAG = "lifecycle";
	Button button1; 
	
	public TwoActivity() {
		Log.d(TAG, "TwoActivity()  - ������ ������������");
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart()   - TwoActivity - Activity ����������� �������");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart() - TwoActivity - ���������� Activity");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume()  - TwoActivity - Activity �������� ����� (��������� Resumed)");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause()   - TwoActivity - Activity �������������� (��������� Paused)");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy() - TwoActivity - Activity ����������");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop()    - TwoActivity - Activity ����������� (��������� Stopped)");
	}	
	
	
}
