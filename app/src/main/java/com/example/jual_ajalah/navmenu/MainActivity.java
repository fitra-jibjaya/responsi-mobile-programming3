package com.example.jual_ajalah.navmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jual_ajalah.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}