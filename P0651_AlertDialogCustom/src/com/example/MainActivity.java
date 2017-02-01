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
		// создаем view из dialog.xml
		view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog, null);
		// устанавливаем ее, как содержимое тела диалога
		adb.setView(view);
		// находим TexView дл€ отображени€ кол-ва
		tvCount = (TextView) view.findViewById(R.id.tvCount);
		return adb.create();
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
		if (id == DIALOG) {
			// Ќаходим TextView дл€ отображени€ времени и показываем текущее
			// врем€
			TextView tvTime = (TextView) dialog.getWindow().findViewById(R.id.tvTime);
			tvTime.setText(sdf.format(new Date(System.currentTimeMillis())));
			// если была нажата кнопка ƒобавить
			if (btn == R.id.btnAdd) {
				// создаем новое TextView, добавл€ем в диалог, указываем текст
				TextView tv = new TextView(this);
				view.addView(tv, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				tv.setText("TextView " + (textViews.size() + 1));
				// добавл€ем новое TextView в коллекцию
				textViews.add(tv);
				// иначе
			} else {
				// если коллекци€ созданных TextView непуста
				if (textViews.size() > 0) {
					// находим в коллекции последний TextView
					TextView tv = textViews.get(textViews.size() - 1);
					// удал€ем из диалога
					view.removeView(tv);
					// удал€ем из коллекции
					textViews.remove(tv);
				}
			}
			// обновл€ем счетчик
			tvCount.setText(" ол-во TextView = " + textViews.size());
		}
	}
}