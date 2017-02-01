package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView img = (ImageView) findViewById(R.id.imageView1);
		img.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_camera));
	}
}
