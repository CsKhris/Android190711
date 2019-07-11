package com.cs.android190711actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Action Bar 가져오기 - show() 나 hide() 를 이용하여 보이게 하거나 숨길 수 있습니다.
        ActionBar acBar = getSupportActionBar();
        acBar.setDisplayShowHomeEnabled(true);
        acBar.setDisplayHomeAsUpEnabled(true);
        acBar.setIcon(R.drawable.icon);

    }
}
