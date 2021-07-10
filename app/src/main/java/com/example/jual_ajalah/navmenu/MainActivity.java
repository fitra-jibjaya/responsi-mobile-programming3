package com.example.jual_ajalah.navmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.jual_ajalah.R;
import com.example.jual_ajalah.fragment.HistoryFragment;
import com.example.jual_ajalah.fragment.HomeFragment;
import com.example.jual_ajalah.fragment.PaymentFragment;
import com.example.jual_ajalah.fragment.SettingsFragments;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_CAMERA = 1;
    private Fragment fragment = null;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChipNavigationBar chipNavigationBar = findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.history:
                    fragment = new HistoryFragment();
                    break;
                case R.id.setting:
                    fragment = new SettingsFragments();
                    break;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
    }

}