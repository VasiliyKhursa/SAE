package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	ActionMode actionMode;
	final String LOG_TAG = "myLogs";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.context, menu);
		return true;
	}

	public void onClick(View v) {
		if (actionMode == null)
			actionMode = startActionMode(callback);
		else
			actionMode.finish();
	}

	private ActionMode.Callback callback = new ActionMode.Callback() {

		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			mode.getMenuInflater().inflate(R.menu.context, menu);
			return true;
		}

		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false;
		}

		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			Log.d(LOG_TAG, "item " + item.getTitle());
			return false;
		}

		public void onDestroyActionMode(ActionMode mode) {
			Log.d(LOG_TAG, "destroy");
			actionMode = null;
		}

	};

}