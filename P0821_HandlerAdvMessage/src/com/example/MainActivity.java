package com.example;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	final int STATUS_NONE = 0; // ��� �����������
	final int STATUS_CONNECTING = 1; // ������������
	final int STATUS_CONNECTED = 2; // ����������
	final int STATUS_DOWNLOAD_START = 3; // �������� ��������
	final int STATUS_DOWNLOAD_FILE = 4; // ���� ��������
	final int STATUS_DOWNLOAD_END = 5; // �������� ���������
	final int STATUS_DOWNLOAD_NONE = 6; // ��� ������ ��� ��������

	Handler h;

	TextView tvStatus;
	ProgressBar pbDownload;
	Button btnConnect;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvStatus = (TextView) findViewById(R.id.tvStatus);
		pbDownload = (ProgressBar) findViewById(R.id.pbDownload);
		btnConnect = (Button) findViewById(R.id.btnConnect);

		h = new Handler() {
			public void handleMessage(android.os.Message msg) {
				switch (msg.what) {
				case STATUS_NONE:
					btnConnect.setEnabled(true);
					tvStatus.setText("Not connected");
					pbDownload.setVisibility(View.GONE);
					break;
				case STATUS_CONNECTING:
					btnConnect.setEnabled(false);
					tvStatus.setText("Connecting");
					break;
				case STATUS_CONNECTED:
					tvStatus.setText("Connected");
					break;
				case STATUS_DOWNLOAD_START:
					tvStatus.setText("Start download " + msg.arg1 + " files");
					pbDownload.setMax(msg.arg1);
					pbDownload.setProgress(0);
					pbDownload.setVisibility(View.VISIBLE);
					break;
				case STATUS_DOWNLOAD_FILE:
					tvStatus.setText("Downloading. Left " + msg.arg2 + " files");
					pbDownload.setProgress(msg.arg1);
					saveFile((byte[]) msg.obj);
					break;
				case STATUS_DOWNLOAD_END:
					tvStatus.setText("Download complete!");
					break;
				case STATUS_DOWNLOAD_NONE:
					tvStatus.setText("No files for download");
					break;
				}
			};
		};
		h.sendEmptyMessage(STATUS_NONE);
	}

	public void onclick(View v) {

		Thread t = new Thread(new Runnable() {
			Message msg;
			byte[] file;
			Random rand = new Random();

			public void run() {
				try {
					// ������������� �����������
					h.sendEmptyMessage(STATUS_CONNECTING);
					TimeUnit.SECONDS.sleep(1);

					// ����������� �����������
					h.sendEmptyMessage(STATUS_CONNECTED);

					// ���������� ���-�� ������
					TimeUnit.SECONDS.sleep(1);
					//int filesCount = rand.nextInt(5);
					int filesCount = 100;

					if (filesCount == 0) {
						// ��������, ��� ������ ��� �������� ���
						h.sendEmptyMessage(STATUS_DOWNLOAD_NONE);
						// � �����������
						TimeUnit.MILLISECONDS.sleep(1500);
						h.sendEmptyMessage(STATUS_NONE);
						return;
					}

					// �������� ����������
					// ������� ���������, � ����������� � ���������� ������
					msg = h.obtainMessage(STATUS_DOWNLOAD_START, filesCount, 0);
					// ����������
					h.sendMessage(msg);

					for (int i = 1; i <= filesCount; i++) {
						// ����������� ����
						file = downloadFile();
						// ������� ��������� � ����������� � ���������� ������
						// �����,
						// ���-��� ���������� � ����� ������
						msg = h.obtainMessage(STATUS_DOWNLOAD_FILE, i, filesCount - i, file);
						// ����������
						h.sendMessage(msg);
					}

					// �������� ���������
					h.sendEmptyMessage(STATUS_DOWNLOAD_END);

					// �����������
					TimeUnit.MILLISECONDS.sleep(1500);
					h.sendEmptyMessage(STATUS_NONE);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
	}

	byte[] downloadFile() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(250);
		return new byte[1024];
	}

	void saveFile(byte[] file) {

	}

}