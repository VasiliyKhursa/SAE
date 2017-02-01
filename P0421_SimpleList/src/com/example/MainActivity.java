package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	String[] names = { "����", "�����", "����", "�����", "����", "�����", "�����", "�����", "����", "�����", "������" };

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ������� ������
		ListView lvMain = (ListView) findViewById(R.id.lvMain);

		// ������� �������
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_list_item, names);

		// ����������� ������� ������
		lvMain.setAdapter(adapter);

	}
}