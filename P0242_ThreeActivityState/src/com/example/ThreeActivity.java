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
		Log.d(TAG, "onCreate()  - ThreeActivity - Activity �������");
	}
	

	final String TAG = "lifecycle";
	Button button1; 
	
	public ThreeActivity() {
		Log.d(TAG, "ThreeActivity()  - ������ ������������");
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart()   - ThreeActivity - Activity ����������� �������");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart() - ThreeActivity - ���������� Activity");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume()  - ThreeActivity - Activity �������� ����� (��������� Resumed)");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause()   - ThreeActivity - Activity �������������� (��������� Paused)");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy() - ThreeActivity - Activity ����������");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop()    - ThreeActivity - Activity ����������� (��������� Stopped)");
	}	
	
	
}
