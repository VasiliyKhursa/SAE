package com.example;

import android.content.Intent;
import android.view.View;

public class ActivityB extends MainActivity {
	public void onClick(View v) {
		startActivity(new Intent(this, ActivityC.class));
	}
}