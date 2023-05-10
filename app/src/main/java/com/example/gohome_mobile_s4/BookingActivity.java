package com.example.gohome_mobile_s4;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {
    private Button btnCheckin, btnCheckout, btnBooking;
    private TextView tipeKamar, noKamar, checkin, checkout, bookingId, namaPlg, nik;
    private ImageView gambarKamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_booking);

        // Menghubungkan variabel dengan view
        btnCheckin = findViewById(R.id.btncheckin);
        btnCheckout = findViewById(R.id.btncheckout);
        btnBooking = findViewById(R.id.btnbooking);
        tipeKamar = findViewById(R.id.tipekamar);
        noKamar = findViewById(R.id.nokamar);
        checkin = findViewById(R.id.checkin);
        checkout = findViewById(R.id.checkout);
        bookingId = findViewById(R.id.bookingid);
        namaPlg = findViewById(R.id.nama_plg);
        nik = findViewById(R.id.nik);
        gambarKamar = findViewById(R.id.gambarkamar);

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
                        checkin.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkin
                    },
                    year,
                    month,
                    dayOfMonth);
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
                        checkout.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkout
                    },
                    year,
                    month,
                    dayOfMonth);
            datePickerDialog.show();
        });

        // Menambahkan onClickListener ke btnBooking
        btnBooking.setOnClickListener(view -> {
            // Melakukan proses booking dan menampilkan ID booking pada TextView bookingId
            String idBooking = doBooking();
            bookingId.setText(idBooking);
        });
    }

    private String doBooking() {
        // Menyimpan data booking pada database atau web service
        // Mengembalikan ID booking
        return "ABC123";
    }
}

