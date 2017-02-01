package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {

	final String TABS_TAG_1 = "Tag 1";
	final String TABS_TAG_2 = "Tag 2";

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		TabHost.TabSpec tabSpec;

		tabSpec = tabHost.newTabSpec(TABS_TAG_1);
		tabSpec.setContent(TabFactory);
		tabSpec.setIndicator("¬кладка 1");
		tabHost.addTab(tabSpec);

		tabSpec = tabHost.newTabSpec(TABS_TAG_2);
		tabSpec.setContent(TabFactory);
		tabSpec.setIndicator("¬кладка 2");
		tabHost.addTab(tabSpec);

	}

	TabHost.TabContentFactory TabFactory = new TabHost.TabContentFactory() {

		@Override
		public View createTabContent(String tag) {
			if (tag == TABS_TAG_1) {
				return getLayoutInflater().inflate(R.layout.tab, null);
			} else if (tag == TABS_TAG_2) {
				TextView tv = new TextView(MainActivity.this);
				tv.setText("Ёто создано вручную");
				return tv;
			}
			return null;
		}
	};
}