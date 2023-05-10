package com.example.gohome_mobile_s4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class EdtprofActivity extends AppCompatActivity {
    EditText txtNama, txtEmail, txtPass, txtTelpon;
    Button btnSimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edtprof);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtNama = findViewById(R.id.txtNama);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        txtTelpon = findViewById(R.id.txtTelpon);
        btnSimpan = findViewById(R.id.btnSimpan);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Mengatur fungsi tombol back pada appbar
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}