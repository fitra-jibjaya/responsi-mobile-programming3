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
import com.example.jual_ajalah.navmenu.MainActivity;
import com.example.jual_ajalah.room.UserDao;
import com.example.jual_ajalah.room.UserDatabase;
import com.example.jual_ajalah.room.UserEntity;

public class RegisterActivity extends AppCompatActivity {

    Button daftar;
    EditText email, password, confirm;
    ImageView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        kembali = findViewById(R.id.cl_back2);

        kembali=(ImageView)findViewById(R.id.cl_back2);
        kembali.setOnClickListener(v -> {
            Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });


        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_pass);
        confirm = findViewById(R.id.et_confirm);
        daftar = findViewById(R.id.btn_daftar);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setEmail(email.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setConfirm(confirm.getText().toString());
                if (validateInput(userEntity)) {
                    if (password.getText().toString().equals(confirm.getText().toString())) {
                        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                        UserDao userDao = userDatabase.userDao();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                userDao.registerUser(userEntity);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    }
                                });
                            }
                        }).start();
                    } else {
                        Toast.makeText(getApplicationContext(), "Password harus sama", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Harap di isi semua", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private Boolean validateInput(UserEntity userEntity) {
        if (userEntity.getEmail().isEmpty() ||
                userEntity.getPassword().isEmpty() ||
                userEntity.getConfirm().isEmpty()) {
            return false;
        }
        return true;
    }
}