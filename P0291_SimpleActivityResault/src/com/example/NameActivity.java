package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends Activity implements View.OnClickListener{
	Button btn;
	EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name);
		
		btn = (Button) findViewById(R.id.button1);
		editText = (EditText) findViewById(R.id.editText1);
		
		btn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.button1) {
			// Создаем Intent
			Intent intent = new Intent();
			// засовываем данные
			intent.putExtra("name", editText.getText().toString());
			// ставим флаг RESULT_OK - означает успешное завершение вызова и добавляем intent с данными
			setResult(RESULT_OK, intent);
			// Завершаем работу Activity
			finish();
		}
	}
}
