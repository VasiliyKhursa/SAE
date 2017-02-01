package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{

	Button btn;
	EditText editTxt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.button1);
		editTxt = (EditText) findViewById(R.id.editText1);
		
		btn.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			// Создаем intent с уже известным названием класса Activity
			Intent intent = new Intent(this, ViewActivity.class);
			// Добавляем пару ключ - значение
			intent.putExtra("name", editTxt.getText().toString());
			startActivity(intent);
		}
	}
}
