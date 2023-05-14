package com.example.gohome_mobile_s4;


import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {
    Button btnTf;
    TextView txt_nama, txt_nik, txt, txt_nomor, txt_Jkamar, tgl_checkin, tgl_checkout, txt_total, note, txt_checkin, txt_checkout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        btnTf = findViewById(R.id.btnTf);
        txt = findViewById(R.id.txt);
        txt_Jkamar = findViewById(R.id.txt_Jkamar);
        txt_nama = findViewById(R.id.txt_name);
        txt_nik = findViewById(R.id.txt_nik);
        txt_nomor = findViewById(R.id.txt_nomor);
        tgl_checkin = findViewById(R.id.tgl_checkin);
        tgl_checkout = findViewById(R.id.tgl_checkout);
        txt_total = findViewById(R.id.txt_total);
        note = findViewById(R.id.note);

        // Menghubungkan variabel dengan view
        // Menambahkan onClickListener ke btnCheckin


        btnTf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PackageManager pm = getApplicationContext().getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://wa.me/+6282127686455?text=Halo, ini pesan dari aplikasi saya."));
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Aplikasi WhatsApp tidak terpasang.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }}
