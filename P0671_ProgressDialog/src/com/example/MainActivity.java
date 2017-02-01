package com.example;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	ProgressDialog pd;
	Handler h;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.btnDefault:
			pd = new ProgressDialog(this);
			pd.setTitle("Title");
			pd.setMessage("Message");
			// ��������� ������
			pd.setButton(Dialog.BUTTON_POSITIVE, "OK", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			pd.show();
			break;
		case R.id.btnHoriz:
			pd = new ProgressDialog(this);
			pd.setTitle("Title");
			pd.setMessage("Message");
			// ������ ����� �� ���������
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// ������������� ��������
			pd.setMax(2148);
			// �������� �������� ��������
			pd.setIndeterminate(true);
			pd.show();
			h = new Handler() {
				public void handleMessage(Message msg) {
					// ��������� �������� ��������
					pd.setIndeterminate(false);
					if (pd.getProgress() < pd.getMax()) {
						// ����������� �������� �����������
						pd.incrementProgressBy(50);
						pd.incrementSecondaryProgressBy(75);
						h.sendEmptyMessageDelayed(0, 100);
					} else {
						pd.dismiss();
					}
				}
			};
			h.sendEmptyMessageDelayed(0, 2000);
			break;
		default:
			break;
		}
	}
}