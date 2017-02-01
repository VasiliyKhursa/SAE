package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        // �������� TabHost
        TabHost tabHost = getTabHost();
         
        // ������������� ���� ��������� � getTabHost
        // ����� setup �������� �� �����
         
        TabHost.TabSpec tabSpec;
         
        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("������� 1");
        tabSpec.setContent(new Intent(this, One.class));
        tabHost.addTab(tabSpec);
         
        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("������� 2");
        tabSpec.setContent(new Intent(this, Two.class));
        tabHost.addTab(tabSpec);
    }
}