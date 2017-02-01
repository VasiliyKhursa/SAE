package com.example;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(LOG_TAG, "MainActivity onCreate");
		setContentView(R.layout.activity_main);
	}

	protected void onStart() {
		super.onStart();
		Log.d(LOG_TAG, "MainActivity onStart");
	}
	

	@Override
	public void onAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub
		super.onAttachFragment(fragment);
		Log.d(LOG_TAG, "MainActivity onAttachFragment");
	}

	protected void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "MainActivity onResume");
	}

	protected void onPause() {
		super.onPause();
		Log.d(LOG_TAG, "MainActivity onPause");
	}

	protected void onStop() {
		super.onStop();
		Log.d(LOG_TAG, "MainActivity onStop");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG, "MainActivity onDestroy");
	}

}