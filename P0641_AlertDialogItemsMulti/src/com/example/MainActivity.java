package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	final int DIALOG_ITEMS = 1;
	final int DIALOG_CURSOR = 3;
	DB db;
	Cursor cursor;

	String data[] = { "one", "two", "three", "four" };
	boolean chkd[] = { false, true, true, false };

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ��������� ����������� � ��
		db = new DB(this);
		db.open();
		cursor = db.getAllData();
		startManagingCursor(cursor);
	}

	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.btnItems:
			showDialog(DIALOG_ITEMS);
			break;
		case R.id.btnCursor:
			showDialog(DIALOG_CURSOR);
			break;
		default:
			break;
		}
	}

	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder adb = new AlertDialog.Builder(this);
		switch (id) {
		// ������
		case DIALOG_ITEMS:
			adb.setTitle(R.string.items);
			adb.setMultiChoiceItems(data, chkd, myItemsMultiClickListener);
			break;
		// ������
		case DIALOG_CURSOR:
			adb.setTitle(R.string.cursor);
			adb.setMultiChoiceItems(cursor, DB.COLUMN_CHK, DB.COLUMN_TXT, myCursorMultiClickListener);
			break;
		}
		adb.setPositiveButton(R.string.ok, myBtnClickListener);
		return adb.create();
	}

	// ���������� ��� ������ �������
	OnMultiChoiceClickListener myItemsMultiClickListener = new OnMultiChoiceClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which, boolean isChecked) {
			Log.d(LOG_TAG, "which = " + which + ", isChecked = " + isChecked);
		}
	};

	// ���������� ��� ������ �������
	OnMultiChoiceClickListener myCursorMultiClickListener = new OnMultiChoiceClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which, boolean isChecked) {
			ListView lv = ((AlertDialog) dialog).getListView();
			Log.d(LOG_TAG, "which = " + which + ", isChecked = " + isChecked);
			db.changeRec(which, isChecked);
			cursor.requery();
		}
	};

	// ���������� ������� �� ������
	OnClickListener myBtnClickListener = new OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			SparseBooleanArray sbArray = ((AlertDialog) dialog).getListView().getCheckedItemPositions();
			for (int i = 0; i < sbArray.size(); i++) {
				int key = sbArray.keyAt(i);
				if (sbArray.get(key))
					Log.d("qwe", "checked: " + key);
			}
		}
	};

	protected void onDestroy() {
		super.onDestroy();
		db.close();
	}

}