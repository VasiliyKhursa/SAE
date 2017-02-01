package com.example;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	MyTask mt;
	TextView tvInfo;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvInfo = (TextView) findViewById(R.id.tvInfo);
	}

	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.btnStartPending:
			startTask();
			break;
		case R.id.btnStartRunning:
			startTask2();
			break;
		case R.id.btnStartCancell:
			startTask3();
			break;
		case R.id.btnStatus:
			showStatus();
			break;
		case R.id.btnStatus2:
			showStatus2();
			break;
		default:
			break;
		}
	}

	private void startTask() {
		mt = new MyTask();
	}

	private void startTask2() {
		mt = new MyTask();
		mt.execute();
	}

	private void startTask3() {
		mt = new MyTask();
		mt.execute();
		mt.cancel(false);
	}

	private void showStatus() {
		if (mt != null)
			Toast.makeText(this, mt.getStatus().toString(), Toast.LENGTH_SHORT).show();
	}

	private void showStatus2() {
		if (mt != null)
			if (mt.isCancelled())
				Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(this, mt.getStatus().toString(), Toast.LENGTH_SHORT).show();
	}

	class MyTask extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			tvInfo.setText("Begin");
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				for (int i = 0; i < 5; i++) {
					if (isCancelled())
						return null;
					TimeUnit.SECONDS.sleep(1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			tvInfo.setText("End");
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
			tvInfo.setText("Cancel");
		}
	}
}