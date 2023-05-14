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
    Button btnCheckin, btnCheckout, btnTf;
    TextView txt_nama, txt_nik, txt, txt_nomor, txt_Jkamar, tgl_checkin, tgl_checkout, txt_total, note;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_booking);
        btnCheckin = findViewById(R.id.btncheckin);
        btnCheckout = findViewById(R.id.btncheckout);
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
        btnCheckin.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            // Membuka date picker dialog saat btnCheckin diklik
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    BookingActivity.this,
                    (datePicker, year1, month1, day) -> {
                        month1 += 1; // Januari dimulai dari 0
                        String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month1, year1);
                        tgl_checkin.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkin
                    },
                    year, month, dayOfMonth);
            datePickerDialog.show();
        });

        // Menambahkan onClickListener ke btnCheckout
        btnCheckout.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            // Membuka date picker dialog saat btnCheckout diklik
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    BookingActivity.this,
                    (datePicker, year1, month1, day) -> {
                        month1 += 1; // Januari dimulai dari 0
                        String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month1, year1);
                        tgl_checkout.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkout
                    },
                                year,
                                month,
                                dayOfMonth);
                        datePickerDialog.show();
        });

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
