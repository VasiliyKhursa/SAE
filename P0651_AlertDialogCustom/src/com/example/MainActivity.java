package com.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	final int DIALOG = 1;

	int btn;
	LinearLayout view;
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	TextView tvCount;
	ArrayList<TextView> textViews;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textViews = new ArrayList<TextView>(10);
	}

	public void onclick(View v) {
		btn = v.getId();
		showDialog(DIALOG);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder adb = new AlertDialog.Builder(this);
		adb.setTitle("Custom dialog");
		// ������� view �� dialog.xml
		view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog, null);
		// ������������� ��, ��� ���������� ���� �������
		adb.setView(view);
		// ������� TexView ��� ����������� ���-��
		tvCount = (TextView) view.findViewById(R.id.tvCount);
		return adb.create();
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
		if (id == DIALOG) {
			// ������� TextView ��� ����������� ������� � ���������� �������
			// �����
			TextView tvTime = (TextView) dialog.getWindow().findViewById(R.id.tvTime);
			tvTime.setText(sdf.format(new Date(System.currentTimeMillis())));
			// ���� ���� ������ ������ ��������
			if (btn == R.id.btnAdd) {
				// ������� ����� TextView, ��������� � ������, ��������� �����
				TextView tv = new TextView(this);
				view.addView(tv, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				tv.setText("TextView " + (textViews.size() + 1));
				// ��������� ����� TextView � ���������
				textViews.add(tv);
				// �����
			} else {
				// ���� ��������� ��������� TextView �������
				if (textViews.size() > 0) {
					// ������� � ��������� ��������� TextView
					TextView tv = textViews.get(textViews.size() - 1);
					// ������� �� �������
					view.removeView(tv);
					// ������� �� ���������
					textViews.remove(tv);
				}
			}
			// ��������� �������
			tvCount.setText("���-�� TextView = " + textViews.size());
		}
	}
}