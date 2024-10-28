package com.fkom.modul1;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    private EditText angkaPertamaEditText;
    private EditText angkaKeduaEditText;
    private  EditText hasilPenjumlahanTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        angkaPertamaEditText = findViewById(R.id.bil1);
        angkaKeduaEditText = findViewById(R.id.bil2);
        hasilPenjumlahanTextView = findViewById(R.id.hasil);

        Button btnTambah = findViewById(R.id.tambah);
        Button btnKurang = findViewById(R.id.kurang);
        Button btnKali = findViewById(R.id.kali);
        Button btnBagi = findViewById(R.id.pembagian);
        Button Clear = findViewById(R.id.clear);



        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("+");
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("-");
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("*");
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("/");
            }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angkaPertamaEditText.setText("");
                angkaKeduaEditText.setText("");
                hasilPenjumlahanTextView.setText("");
            }
        });


    }

    private void hitung(String operator) {
        double angka1 = Double.parseDouble(angkaPertamaEditText.getText().toString());
        double angka2 = Double.parseDouble(angkaKeduaEditText.getText().toString());
        double hasil = 0;

        switch (operator) {
            case "+":
                hasil = angka1 + angka2;
                break;
            case "-":
                hasil = angka1 - angka2;
                break;
            case "*":
                hasil = angka1 * angka2;
                break;
            case "/":
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                } else {
                    hasilPenjumlahanTextView.setText("Tidak bisa dibagi oleh nol!");
                    return;
                }
                break;
        }

        String formattedResult;
        if (hasil == (int) hasil) {
            formattedResult = String.valueOf((int) hasil);
        } else {
            formattedResult = new DecimalFormat("#.#####").format(hasil);
        }

        hasilPenjumlahanTextView.setText(formattedResult);
    }
}