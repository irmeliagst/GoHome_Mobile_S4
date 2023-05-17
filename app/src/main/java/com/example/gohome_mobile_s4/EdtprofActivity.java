package com.example.gohome_mobile_s4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gohome_mobile_s4.Model.profile.Profile;
import com.example.gohome_mobile_s4.retrofit.ApiInterface;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EdtprofActivity extends AppCompatActivity {
    String nik, email, nama_pengunjung, telepon;
    EditText txtNama, txtEmail, txtTelpon;
    Button btnSimpan;
    Button updated;
    SesionManager sesionManager;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edtprof);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sesionManager = new SesionManager(EdtprofActivity.this);
        Log.d("NIK", sesionManager.getUserDetail().get(SesionManager.NIK));
        txtNama = findViewById(R.id.txtNama);
        if(SesionManager.NAMA_PENGUNJUNG == null){
            txtNama.setHint("Masukan nama");
        } else {
            txtNama.setText(sesionManager.getUserDetail().get(SesionManager.NAMA_PENGUNJUNG));
        }
        txtEmail = findViewById(R.id.txtEmail);
        if(SesionManager.EMAIL == null){
            txtEmail.setHint("Masukan Email");
        } else {
            txtEmail.setText(sesionManager.getUserDetail().get(SesionManager.EMAIL));
        }
        txtTelpon = findViewById(R.id.txtTelpon);
        if(SesionManager.TELEPON == null){
            txtTelpon.setHint("Masukan nama");
        } else {
            txtTelpon.setText(sesionManager.getUserDetail().get(SesionManager.TELEPON));
        }
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                switch (v.getId()){

                    case R.id.btnSimpan:

                        nik = sesionManager.getUserDetail().get(SesionManager.NIK);
                        email = txtEmail.getText().toString().isEmpty() ? sesionManager.getUserDetail().get(SesionManager.EMAIL) : txtEmail.getText().toString();
                        nama_pengunjung = txtNama.getText().toString().isEmpty() ? sesionManager.getUserDetail().get(SesionManager.NAMA_PENGUNJUNG) : txtNama.getText().toString();
                        telepon = txtTelpon.getText().toString().isEmpty() ? sesionManager.getUserDetail().get(SesionManager.TELEPON) : txtTelpon.getText().toString();
                        kirim(nik, nama_pengunjung, telepon, email);
                        break;


                }
            }
        });

    }

    private void kirim(String nik, String nama_pengunjung, String telepon, String email) {
        apiInterface = RetrofitClient.getInstance().getMyApi();
        Call<Profile> Ucall = apiInterface.updateAkun(nik, email, nama_pengunjung, telepon);
        Ucall.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Toast.makeText(EdtprofActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("GETDATA" , response.body().getMessage());
                    System.err.println(response.body());
                } else {
                    System.err.println(response.body());
                    Toast.makeText(EdtprofActivity.this, "Update failed: " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(EdtprofActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("SERVER", t.toString());
            }
        });
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