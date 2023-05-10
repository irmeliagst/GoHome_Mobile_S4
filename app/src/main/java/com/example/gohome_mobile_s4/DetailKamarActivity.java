package com.example.gohome_mobile_s4;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

        // Inisialisasi view
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = findViewById(R.id.imageView5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView nameTextView = findViewById(R.id.tipekamar);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView bedTextView = findViewById(R.id.kasur);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView priceTextView = findViewById(R.id.harga);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView descriptionTextView = findViewById(R.id.deskripsi);

        // Mendapatkan data dari intent
        String name = getIntent().getStringExtra("name");
        String bed = getIntent().getStringExtra("bed");
        String price = getIntent().getStringExtra("price");
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("imageResId", 0);

        // Mengatur data ke view
        imageView.setImageResource(imageResId);
        nameTextView.setText(name);
        bedTextView.setText(bed);
        priceTextView.setText(price);
        descriptionTextView.setText(description);
    }
}
