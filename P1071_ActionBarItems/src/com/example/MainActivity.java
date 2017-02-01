package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ������ Action Bar
		//getActionBar().hide();
		
		// ������ ������ HOME
		//getActionBar().setDisplayShowHomeEnabled(false);
		
		// �������� ������� �� ������
		getActionBar().setHomeButtonEnabled(true);
		
		// ������� ���������
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// ��������/�������� ���������
		getActionBar().setTitle("���������");
		
		// ��������/�������� ������������
		getActionBar().setSubtitle("������������");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}