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
         
        // получаем TabHost
        TabHost tabHost = getTabHost();
         
        // инициализаци€ была выполнена в getTabHost
        // метод setup вызывать не нужно
         
        TabHost.TabSpec tabSpec;
         
        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("¬кладка 1");
        tabSpec.setContent(new Intent(this, One.class));
        tabHost.addTab(tabSpec);
         
        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("¬кладка 2");
        tabSpec.setContent(new Intent(this, Two.class));
        tabHost.addTab(tabSpec);
    }
}