package com.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class BrouserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brouser);
		
		WebView webView = (WebView) findViewById(R.id.webView);
		Intent intent = getIntent();
		Uri data = intent.getData();
		webView.loadUrl(data.toString());
	}
}
