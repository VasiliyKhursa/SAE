package com.example;

import java.util.concurrent.TimeUnit;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	Handler h;
	TextView tvInfo;
	Button btnStart;
	Button btnStartNewTgood;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvInfo = (TextView) findViewById(R.id.tvInfo);

		btnStartNewTgood = (Button) findViewById(R.id.btnStartNewTgood);
		h = new Handler() {
			public void handleMessage(android.os.Message msg) {
				// обновляем TextView
				tvInfo.setText("Закачано файлов: " + msg.what);
				if (msg.what == 10)
					btnStartNewTgood.setEnabled(true);
			};
		};
	}

	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.btnStart:
			for (int i = 1; i <= 10; i++) {
				// долгий процесс
				downloadFile();
				// обновляем TextView
				tvInfo.setText("Закачано файлов: " + i);
				// пишем лог
				Log.d(LOG_TAG, "Закачано файлов: " + i);
			}
			break;
		case R.id.btnTest:
			Log.d(LOG_TAG, "test");
			break;

		case R.id.btnStartNewT:
			Thread t = new Thread(new Runnable() {
				public void run() {
					for (int i = 1; i <= 10; i++) {
						// долгий процесс
						downloadFile();
						// обновляем TextView
						tvInfo.setText("Закачано файлов: " + i);
						// пишем лог
						Log.d(LOG_TAG, "i = " + i);
					}
				}
			});
			t.start();
			break;

		case R.id.btnStartNewTgood:
			btnStartNewTgood.setEnabled(false);
			Thread t2 = new Thread(new Runnable() {
				public void run() {
					for (int i = 1; i <= 10; i++) {
						// долгий процесс
						downloadFile();
						h.sendEmptyMessage(i);
						// пишем лог
						Log.d(LOG_TAG, "i = " + i);
					}
				}
			});
			t2.start();
			break;

		default:
			break;
		}
	}

	void downloadFile() {
		// пауза - 1 секунда
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}