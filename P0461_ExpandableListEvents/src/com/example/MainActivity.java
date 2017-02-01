package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class MainActivity extends Activity 
	implements OnGroupClickListener, OnChildClickListener, OnGroupCollapseListener, OnGroupExpandListener {

	final String LOG_TAG = "myLogs";

	ExpandableListView elvMain;
	AdapterHelper ah;
	SimpleExpandableListAdapter adapter;
	TextView tvInfo;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvInfo = (TextView) findViewById(R.id.tvInfo);

		// ������� �������
		ah = new AdapterHelper(this);
		adapter = ah.getAdapter();

		elvMain = (ExpandableListView) findViewById(R.id.elvMain);
		elvMain.setAdapter(adapter);

		// ��������� ����������
		// ������� �� �������
		elvMain.setOnChildClickListener(this);
		// ������� �� ������
		elvMain.setOnGroupClickListener(this);
		// ������������ ������
		elvMain.setOnGroupCollapseListener(this);
		// �������������� ������
		elvMain.setOnGroupExpandListener(this);
		
		
		// ������������� ������ � �������� 2
		elvMain.expandGroup(2);
		
	}

	
	// �����������
	@Override
	public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
		Log.d(LOG_TAG, "onGroupClick groupPosition = " + groupPosition + " id = " + id);
		// ��������� ���������� ��������� ������� ��� ������ � ��������
		// 1
		if (groupPosition == 1)
			return true;

		return false;
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition,
			long id) {
		Log.d(LOG_TAG, "onChildClick groupPosition = " + groupPosition + " childPosition = " + childPosition
				+ " id = " + id);
		tvInfo.setText(ah.getGroupChildText(groupPosition, childPosition));
		return false;
	}

	@Override
	public void onGroupCollapse(int groupPosition) {
		Log.d(LOG_TAG, "onGroupCollapse groupPosition = " + groupPosition);
		tvInfo.setText("�������� " + ah.getGroupText(groupPosition));
	}

	@Override
	public void onGroupExpand(int groupPosition) {
		Log.d(LOG_TAG, "onGroupExpand groupPosition = " + groupPosition);
		tvInfo.setText("���������� " + ah.getGroupText(groupPosition));
	}
}