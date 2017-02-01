package ru.startandroid.develop.p0971servicebindclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	final String LOG_TAG = "myLogs";

	boolean bound = false;
	Intent intent;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		intent = new Intent("ru.startandroid.develop.p0972servicebindserver.MyService");

	}
	
	ServiceConnection sConn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(LOG_TAG, "MainActivity onServiceDisconnected");
			//Log.d(LOG_TAG, "ComponentName - " + name.toString());
			//Log.d(LOG_TAG, "PackageName - " + name.getPackageName());
			//Log.d(LOG_TAG, "ClassName - " + name.getClassName());
			//Log.d(LOG_TAG, "ShortClassName - " + name.getShortClassName());
			bound = false;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			Log.d(LOG_TAG, "MainActivity onServiceConnected");
			//Log.d(LOG_TAG, "ComponentName - " + name.toString());
			//Log.d(LOG_TAG, "PackageName - " + name.getPackageName());
			//Log.d(LOG_TAG, "ClassName - " + name.getClassName());
			//Log.d(LOG_TAG, "ShortClassName - " + name.getShortClassName());
			
			bound = true;
		}
	};

	public void onClickStart(View v) {
		startService(intent);
	}


	public void onClickStop(View v) {
		stopService(intent);
	}

	public void onClickBind(View v) {
		bindService(intent, sConn, BIND_AUTO_CREATE);
	}

	public void onClickUnBind(View v) {
		if (!bound)
			return;
		unbindService(sConn);
		bound = false;
	}
	
	public boolean onUnbind2(Intent intent) {
		  Log.d(LOG_TAG, "MyService onUnbind");
		  return true;
		}

	protected void onDestroy() {
		super.onDestroy();
		onClickUnBind(null);
	}
}