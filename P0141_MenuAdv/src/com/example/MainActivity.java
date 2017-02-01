package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener{

	CheckBox chkb1;
	CheckBox chkb2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		chkb1 = (CheckBox) findViewById(R.id.checkBox1);
		chkb2 = (CheckBox) findViewById(R.id.checkBox2); 
		
//		chkb1.setOnCheckedChangeListener(this);
//		chkb2.setOnCheckedChangeListener(this);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		
		menu.add(2, 4, 5, "item4").setCheckable(true);	
		//menu.add(2, 4, 5, "item4").setIcon(R.id.action_settings).setCheckable(true).setTitle("txt");	
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		
		switch (id) {
		case R.id.action_mail:
			
			break;
		case R.id.action_settings:
			
			break;
		case R.id.item1:
			item.setChecked(!item.isChecked());
			break;
		case R.id.item2:
			
			break;
		case R.id.item3:
			
			break;
		case 4:
			item.setChecked(!item.isChecked());
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		MenuItem action_mail = menu.findItem(R.id.action_mail);
		
		// Скрытие или отображение отдельного пункта меню
		if (chkb2.isChecked()) {
			action_mail.setVisible(true);
		}
		else {
			action_mail.setVisible(false);
			
			//Удаление пункта меню
			//menu.removeItem(R.id.item1);
		}
		
		
		// пункты меню с ID группы = R.id.group1  видны, если в CheckBox стоит галка
		menu.setGroupVisible(R.id.group1, chkb1.isChecked());
		
	
		return super.onPrepareOptionsMenu(menu);
	}
	
	

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
/*		
		switch (buttonView.getId()) {
		case R.id.checkBox1:

			//MenuItem action_mail = menu.findItem(R.id.action_mail);
//			if (buttonView.isChecked()) {
				this.getApplication().getM
				action_mail.setVisible(true);
			}
			else {
				action_mail.setVisible(false);
			}
			break;
		case R.id.checkBox2:
			if (buttonView.isChecked()) {
//				menu.setGroupVisible(R.id.group1, chkb2.isChecked());
			}
			else {
//				menu.setGroupVisible(R.id.group1, chkb2.isChecked());
			}
			break;

		default:
			break;
		}
*/		
	}
}
