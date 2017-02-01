package com.example;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

	MyTask mt;
	TextView tv;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("qwe", "create MainActivity: " + this.hashCode());

		tv = (TextView) findViewById(R.id.tv);

		mt = new MyTask();
		Log.d("qwe", "create MyTask: " + mt.hashCode());
		mt.execute();
	}
	
	//@SuppressWarnings("deprecation")
	public void onCreate2(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_main);
		  Log.d("qwe", "create MainActivity: " + this.hashCode());
		 
		  tv = (TextView) findViewById(R.id.tv);
		 
		  mt = (MyTask) getLastNonConfigurationInstance();
		  if (mt == null) {
		    mt = new MyTask();
		    mt.execute();
		  }
		  Log.d("qwe", "create MyTask: " + mt.hashCode());
		}

	class MyTask extends AsyncTask<String, Integer, Void> {

		@Override
		protected Void doInBackground(String... params) {
			try {
				for (int i = 1; i <= 10; i++) {
					TimeUnit.SECONDS.sleep(1);
					publishProgress(i);
					Log.d("qwe", "i = " + i + ", MyTask: " + this.hashCode() + ", MainActivity: "
							+ MainActivity.this.hashCode());
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			tv.setText("i = " + values[0]);
		}
	}
	
	public Object onRetainNonConfigurationInstance() {
		  return mt;
		}
}