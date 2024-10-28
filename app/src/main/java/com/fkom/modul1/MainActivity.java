package com.fkom.modul1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button btnLogin;


    private  String Username = "Rifkydewani";
    private  String Password = "Rifky123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equalsIgnoreCase(Username)&& password.getText().toString().equalsIgnoreCase(Password)){
                    Intent login = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(login);
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Username dan Password Salah", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
