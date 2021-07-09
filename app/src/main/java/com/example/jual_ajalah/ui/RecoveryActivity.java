package com.example.jual_ajalah.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jual_ajalah.R;
import com.example.jual_ajalah.room.UserDao;
import com.example.jual_ajalah.room.UserDatabase;
import com.example.jual_ajalah.room.UserEntity;

public class RecoveryActivity extends AppCompatActivity {

    ImageView imageView;
    EditText email;
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

        email =findViewById(R.id.et_email);
        button =findViewById(R.id.btn_kirim);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                if (emailText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Harap di isi semua", Toast.LENGTH_SHORT).show();
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.recovery(emailText);
                            if (userEntity == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Email Salah", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                startActivity(new Intent(RecoveryActivity.this, LoginActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });
    }
}