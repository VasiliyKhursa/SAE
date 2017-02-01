package com.example;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity {

	static final String TAG = "myLogs";
	static final int PAGE_COUNT = 10;

	ViewPager pager;
	PagerAdapter pagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		pager = (ViewPager) findViewById(R.id.pager);
		pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(pagerAdapter);

		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				Log.d(TAG, "onPageSelected, position = " + position);
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
	}

	private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return PageFragment.newInstance(position);
		}

		@Override
		public int getCount() {
			return PAGE_COUNT;
		}

	}

}