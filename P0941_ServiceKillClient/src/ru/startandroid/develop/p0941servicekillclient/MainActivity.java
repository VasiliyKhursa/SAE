package ru.startandroid.develop.p0941servicekillclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClickStart(View v) {
		startService(new Intent("ru.startandroid.develop.p0942servicekillserver.MyService").putExtra("name", "value"));
	}
}