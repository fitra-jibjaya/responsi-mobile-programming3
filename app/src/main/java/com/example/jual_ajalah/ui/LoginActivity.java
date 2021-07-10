package com.example.jual_ajalah.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jual_ajalah.navmenu.MainActivity;
import com.example.jual_ajalah.R;
import com.example.jual_ajalah.room.UserDao;
import com.example.jual_ajalah.room.UserDatabase;
import com.example.jual_ajalah.room.UserEntity;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    Button login;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


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

        email=(EditText)findViewById(R.id.et_email);
        password=(EditText)findViewById(R.id.et_pass);
        login=(Button)findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                if (emailText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Harap di isi semua", Toast.LENGTH_SHORT).show();
                } else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(emailText, passwordText);
                            if (userEntity == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Akun Belum Terdaftar", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                        }
                    }).start();
                }
            }
        });


    }
}