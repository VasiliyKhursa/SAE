package com.example;

import com.example.TitlesFragment.onItemClickListener;

import android.R;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements onItemClickListener {

	int position = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		if (savedInstanceState != null)
			position = savedInstanceState.getInt("position");
		showDetails(position);
	}

	void showDetails(int pos) {
		DetailsFragment details = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.cont);
		if (details == null || details.getPosition() != pos) {
			details = DetailsFragment.newInstance(pos);
			getSupportFragmentManager().beginTransaction().replace(R.id.cont, details).commit();
		}
	}

	@Override
	public void itemClick(int position) {
		this.position = position;
		showDetails(position);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("position", position);
	}
}