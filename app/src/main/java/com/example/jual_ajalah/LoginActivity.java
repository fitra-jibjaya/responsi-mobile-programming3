package com.example.jual_ajalah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button=(Button)findViewById(R.id.btn_login);
        button.setOnClickListener(v -> {
            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            Toast.makeText(LoginActivity.this, "Sukses Login", Toast.LENGTH_SHORT).show();
        });

        textView=(TextView)findViewById(R.id.click1);
        textView.setOnClickListener(v -> {
            Intent intent=new Intent(LoginActivity.this, RecoveryActivity.class);
            startActivity(intent);
        });

        textView=(TextView)findViewById(R.id.click2);
        textView.setOnClickListener(v -> {
            Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}