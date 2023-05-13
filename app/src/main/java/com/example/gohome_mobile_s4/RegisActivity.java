package com.example.gohome_mobile_s4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gohome_mobile_s4.Model.register.RegisterRespon;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisActivity extends AppCompatActivity {

    TextInputEditText emailEdit, nikEdit, passEdit, namaEdit, telponEdit;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        emailEdit = findViewById(R.id.emailEdit);
        nikEdit = findViewById(R.id.nikEdit);
        namaEdit = findViewById(R.id.namaEdit);
        telponEdit = findViewById(R.id.telponEdit);
        passEdit = findViewById(R.id.passEdit);
        btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnReg:
                        String NikEdit = nikEdit.getText().toString();
                        String NamaEdit = namaEdit.getText().toString();
                        String EmailEdit = emailEdit.getText().toString();
                        String PassEdit = passEdit.getText().toString();

                        String TelponEdit = telponEdit.getText().toString();
                        register(NikEdit, NamaEdit, EmailEdit, PassEdit, TelponEdit);

                        Toast.makeText(RegisActivity.this,
                                EmailEdit + PassEdit,
                            Toast.LENGTH_LONG).show();
                }

//                if (v.getId() == R.id.btnLogin) {
//                    String nik = nikEdit.getText().toString();
//                    String nama_pengunjung = namaEdit.getText().toString();
//                    String email = emailEdit.getText().toString();
//                    String password = passEdit.getText().toString();
//                    String telepon = telponEdit.getText().toString();
//                    register(nik, nama_pengunjung, email, password, telepon);
//
//                    Toast.makeText(RegisActivity.this,
//                            "NIK: " + nik +
//                                    "Nama Pengunjung: " + nama_pengunjung +
//                                    "Email: " + email +
//                                    "Password: " + password +
//                                    "Telepon: " + telepon,
//                            Toast.LENGTH_LONG).show();
//
//                } else if (v.getId() == R.id.txtRegister) {
//                    Intent intent = new Intent(RegisActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                }

            }
        });
    }

    private void register(String nik, String nama_pengunjung, String email, String password, String telepon) {
        Call<RegisterRespon> call = RetrofitClient.getInstance().getMyApi().register(nik, nama_pengunjung, email, password, telepon);
        call.enqueue(new Callback<RegisterRespon>() {
            @Override
            public void onResponse(Call<RegisterRespon> call, Response<RegisterRespon> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RegisterRespon registerRespon = response.body();
                    if (registerRespon.isSuccess()) {
                        Toast.makeText(RegisActivity.this, registerRespon.getMassage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisActivity.this, registerRespon.getMassage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterRespon> call, Throwable t) {
                Toast.makeText(RegisActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
