package com.example.jual_ajalah.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jual_ajalah.R;

public class RecoveryActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        imageView=(ImageView)findViewById(R.id.cl_back1);
        imageView.setOnClickListener(v -> {
            Intent intent=new Intent(RecoveryActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        button=(Button)findViewById(R.id.btn_kirim);
        button.setOnClickListener(v -> {
            Intent intent=new Intent(RecoveryActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}