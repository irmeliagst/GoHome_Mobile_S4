package com.example.gohome_mobile_s4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gohome_mobile_s4.Model.login.Data;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextView txtRegister;
    TextInputEditText emailEdit, passEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEdit = findViewById(R.id.emailEdit);
        passEdit = findViewById(R.id.passEdit);
        txtRegister = findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnLogin) {
                    String email = emailEdit.getText().toString();
                    String password = passEdit.getText().toString();
                    login(email, password);
                } else if (v.getId() == R.id.txtRegister) {
                    Intent intent = new Intent(LoginActivity.this, RegisActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void login(String email, String password) {
        Call<Data> loginCall = RetrofitClient.getInstance().getMyApi().login(email, password);
        loginCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.body() != null && response.body().isSuccess() && response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, response.body().getEmail(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, BottomnavActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("DATA", t.toString());
            }
       });
    }
}