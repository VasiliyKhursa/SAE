package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Скрыть Action Bar
		//getActionBar().hide();
		
		// Скрыть кнопку HOME
		//getActionBar().setDisplayShowHomeEnabled(false);
		
		// Включить нажатие на кнопку
		getActionBar().setHomeButtonEnabled(true);
		
		// Доавить стрелочку
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// Добавить/поменять заголовок
		getActionBar().setTitle("Заголовок");
		
		// Добавить/поменять подзаголовок
		getActionBar().setSubtitle("Подзаголовок");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}