package com.example.gohome_mobile_s4;


import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gohome_mobile_s4.Adapter.HomeAdapter;
import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.Tanggal;
import com.example.gohome_mobile_s4.Model.booking.Booking;
import com.example.gohome_mobile_s4.Model.total.Total;
import com.example.gohome_mobile_s4.retrofit.ApiInterface;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity {
    Button btnTf;
    int idKamar;
    Button btnCheckin, btnCheckout, btnFilter, btnSave;
    String Nik, status, total, id_kamar;

    Context context;
    SharedPreferences pref;
    private RecyclerView recyclerView;
    private HomeAdapter myAdapter;
    private List<HomeModel> kamarList;
    SharedPreferences.Editor editor;
    SesionManager sesionManager;
    private String tanggal_checkin, tanggal_checkout;

    Tanggal tanggal = new Tanggal();
    TextView txt_nama, txt_nik, txt_nomor, txt_Jkamar, txt_total, note, set_checkin, set_checkout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = this.getSharedPreferences("tanggal", 0); // 0 - for private mode
        editor = pref.edit();
        sesionManager = new SesionManager(BookingActivity.this);
        System.out.println(pref.getString("tgl_checkin", ""));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        idKamar = intent.getIntExtra("id_kamar", 0);
        String jenis_kamar = String.valueOf(extras.get("jenis_kamar"));
        int harga = intent.getIntExtra("harga", 0);
        String nomer_kamar = String.valueOf(extras.get("nomer_kamar"));
        // Buat instance RetrofitClient
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        // Buat instance API service
        ApiInterface apiInterface = retrofitClient.getMyApi();
        txt_Jkamar = findViewById(R.id.txt_Jkamar);
        txt_Jkamar.setText(jenis_kamar);
        txt_nomor = findViewById(R.id.txt_nomor);
        txt_nomor.setText(nomer_kamar);
        txt_total = findViewById(R.id.txt_total);
        set_checkin = findViewById(R.id.set_checkin);
        set_checkout = findViewById(R.id.set_checkout);
        note = findViewById(R.id.note);
        txt_nama = findViewById(R.id.txt_name);
        txt_nama.setText(sesionManager.getUserDetail().get(SesionManager.NAMA_PENGUNJUNG));
        txt_nik = findViewById(R.id.txt_nik);
        txt_nik.setText(sesionManager.getUserDetail().get(SesionManager.NIK));
        btnTf = findViewById(R.id.btnTf);
        btnTf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PackageManager pm = getApplicationContext().getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://wa.me/+6282127686455?text=Halo, saya booking kamar ini bukti transfernya."));
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Aplikasi WhatsApp tidak terpasang.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        btnFilter = findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tanggal_checkin = tanggal.getTanggal_checkin();
                String tanggal_checkout = tanggal.getTanggal_checkout();
                getTotal(tanggal_checkin, tanggal_checkout);
                System.out.println(tanggal_checkin + " - " + tanggal_checkout);
//                SharedPreferences prefs = getSharedPreferences("tanggal", Context.MODE_PRIVATE);
//                System.out.println(prefs.getString("set_checkin", ""));


            }
        });
        btnCheckin = findViewById(R.id.btncheckin);
        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                // Membuka date picker dialog saat btnCheckin diklik
                DatePickerDialog datePickerDialog = new DatePickerDialog(BookingActivity.this, (datePicker, year1, month1, day) -> {
                    month1 += 1; // Januari dimulai dari 0
                    String selectedDate = String.format(Locale.getDefault(), "%02d-%02d-%d", day, month1, year1);
                    tanggal.setTanggal_checkin(selectedDate);
                    set_checkin.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkin
                },
                        year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
        // Menambahkan onClickListener ke btnCheckout
        btnCheckout = findViewById(R.id.btncheckout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                // Membuka date picker dialog saat btnCheckin diklik
                DatePickerDialog datePickerDialog = new DatePickerDialog(BookingActivity.this, (datePicker, year1, month1, day) -> {
                    month1 += 1; // Januari dimulai dari 0
                    String selectedDate = String.format(Locale.getDefault(), "%02d-%02d-%d", day, month1, year1);
                    tanggal.setTanggal_checkout(selectedDate);
                    set_checkout.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkin
                },
                        year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String km = String.valueOf(idKamar);
                String Nik = sesionManager.getUserDetail().get(SesionManager.NIK);
                String Id_kamar = km;
                String Tanggal_checkin = tanggal.getTanggal_checkin();
                String Tanggal_checkout = tanggal.getTanggal_checkout();

                String Total = txt_total.getText().toString();

               permen(Tanggal_checkin, Tanggal_checkout, Total, Nik, Id_kamar);
            }
        });
    }

    private void permen(String tanggal_checkin, String tanggal_checkout, String total, String nik, String id_kamar) {
        Call<Booking> call = RetrofitClient.getInstance().getMyApi().dataTransaksi(tanggal_checkin, tanggal_checkout, total, nik, id_kamar );

        call.enqueue(new Callback<Booking>() {
            @Override
            public void onResponse(Call<Booking> call, Response<Booking> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    makeText(BookingActivity.this, "Berhasil booking", Toast.LENGTH_SHORT).show();
                } else {
                    makeText(BookingActivity.this,  id_kamar , Toast.LENGTH_SHORT).show();
                    makeText(BookingActivity.this,  total , Toast.LENGTH_SHORT).show();
                    makeText(BookingActivity.this,  tanggal_checkout , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Booking> call, Throwable t) {
                Toast.makeText(BookingActivity.this, "An error has occurred", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getTotal(String tanggal_checkin, String tanggal_checkout) {


        Call<Total> call = RetrofitClient.getInstance().getMyApi().getTotal(idKamar, tanggal_checkin, tanggal_checkout);
        call.enqueue(new Callback<Total>() {
            @Override
            public void onResponse(Call<Total> call, Response<Total> response) {
                if (response.isSuccessful()) {
                    Total totalResponse = response.body();
                    if (totalResponse != null) {
                        int totalHarga = totalResponse.getTotal();
                        System.out.println(response.body() + tanggal_checkin + tanggal_checkout);
                        // Menggunakan totalHarga sesuai kebutuhan Anda
                        // Misalnya, mengatur nilai totalHarga ke TextView
                        txt_total.setText(String.valueOf(totalHarga));
                    }
                } else {
                    // Handle error jika request tidak berhasil
                    // ...
                }
            }

            @Override
            public void onFailure(Call<Total> call, Throwable t) {
                Toast.makeText(BookingActivity.this, "An error has occurred", Toast.LENGTH_LONG).show();
            }
        });
    }
}
