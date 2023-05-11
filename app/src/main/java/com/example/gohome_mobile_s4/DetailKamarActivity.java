package com.example.gohome_mobile_s4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailKamarActivity extends AppCompatActivity {
    Button btnpesan;
    TextView kasur;
    TextView harga;
    TextView deskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kamar);

        // Inisialisasi tombol "Book Room"
        btnpesan = findViewById(R.id.btnpesan);
        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Arahkan ke halaman pemesanan (booking)
                Intent intent = new Intent(DetailKamarActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        // Inisialisasi view
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = findViewById(R.id.imageView5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView nameTextView = findViewById(R.id.tipekamar);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView bedTextView = findViewById(R.id.kasur);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView priceTextView = findViewById(R.id.harga);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView descriptionTextView = findViewById(R.id.deskripsi);

        // Mendapatkan data dari intent
        String tipekamar = getIntent().getStringExtra("tipekamar");
        String kasur = getIntent().getStringExtra("kasur");
        String harga = getIntent().getStringExtra("harga");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        int imageView5 = getIntent().getIntExtra("imageView5", 0);

        // Mengatur data ke view
        imageView.setImageResource(imageView5);
        nameTextView.setText(tipekamar);
        bedTextView.setText(kasur);
        priceTextView.setText(harga);
        descriptionTextView.setText(deskripsi);
    }
}
