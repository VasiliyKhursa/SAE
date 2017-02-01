package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игорь", "Анна", "Денис", "Андрей" };

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// находим список
		ListView lvMain = (ListView) findViewById(R.id.lvMain);

		// создаем адаптер
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_list_item, names);

		// присваиваем адаптер списку
		lvMain.setAdapter(adapter);

	}
}