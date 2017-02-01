package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add("Test");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		switch (id) {
		case R.id.action_settings:
			
			break;
		case R.id.item1:
			//Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();			
			break;
		case R.id.item2:
			//Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();			
			break;
		case R.id.item3:
			//Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();			
			break;

		default:
			//Toast.makeText(this, "default", Toast.LENGTH_SHORT).show();
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
