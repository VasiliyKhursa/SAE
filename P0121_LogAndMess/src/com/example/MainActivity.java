package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
	Button button1;
	Button button2;
	Button button3;
	TextView textView;
	
	String TAG = "myLogs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d(TAG, "найдем View - элементы");
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		
		textView = (TextView) findViewById(R.id.textView1);
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(MainActivity.this, "Нажата кнопка 1", Toast.LENGTH_LONG).show();
				
				//textView.setText("Нажата кнопка 1");
			}
		});
		
		
		button2.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d(TAG, "нажата кнока 2");
		textView.setText("Нажата кнопка 2");
		Toast toast2 = Toast.makeText(MainActivity.this, "Нажата кнопка 22", Toast.LENGTH_LONG);
		toast2.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastImage = (LinearLayout) toast2.getView();
		ImageView imageView = new ImageView(MainActivity.this);
		imageView.setImageResource(R.drawable.ic_launcher);
		toastImage.addView(imageView, 0);
		//toast2.setView(imageView);
		toast2.show();
	}
	
	public void onClickMy(View v) {
		Log.d(TAG, "нажата кнока 3");
		textView.setText("Нажата кнопка 3");
		Toast toast = Toast.makeText(MainActivity.this, "Нажата кнопка 3", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}
