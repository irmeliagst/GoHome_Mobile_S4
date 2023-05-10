package com.example.gohome_mobile_s4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RegisActivity extends AppCompatActivity {
    TextInputEditText emailEdit, nikEdit, passEdit, namaEdit, telponEdit;
    TextView txtLogin;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        emailEdit = findViewById(R.id.emailEdit);
        nikEdit = findViewById(R.id.nikEdit);
        namaEdit= findViewById(R.id.namaEdit);
        telponEdit = findViewById(R.id.telponEdit);
        passEdit = findViewById(R.id.passEdit);
        btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}