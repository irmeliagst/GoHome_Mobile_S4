package com.example.gohome_mobile_s4;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gohome_mobile_s4.Adapter.HomeAdapter;
import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.retrofit.ApiInterface;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class homeFragment extends Fragment {
    Button btnCheckin, btnCheckout;
    TextView set_checkin, set_checkout;
    private RecyclerView recyclerView;
    private HomeAdapter myAdapter;
    private List<HomeModel> kamarList;
    private LinearLayoutManager layoutManager;


    public homeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnCheckin = view.findViewById(R.id.btncheckin);
        btnCheckout = view.findViewById(R.id.btncheckout);
        set_checkin = view.findViewById(R.id.set_checkin);
        set_checkout = view.findViewById(R.id.set_checkout);
        recyclerView = view.findViewById(R.id.kamar_tampil);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        getKamar();
        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            // Membuka date picker dialog saat btnCheckin diklik
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), (datePicker, year1, month1, day) -> {
                        month1 += 1; // Januari dimulai dari 0
                        String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month1, year1);
                        set_checkin.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkin
                    },
                    year, month, dayOfMonth);
            datePickerDialog.show();
            }
        });

        // Menambahkan onClickListener ke btnCheckout
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            // Membuka date picker dialog saat btnCheckout diklik
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    (datePicker, year1, month1, day) -> {
                        month1 += 1; // Januari dimulai dari 0
                        String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month1, year1);
                        set_checkout.setText(selectedDate); // Menampilkan tanggal yang dipilih pada TextView checkout
                    },
                    year,
                    month,
                    dayOfMonth);
            datePickerDialog.show();
            }
//
        });
        return view;
    }

    private void getKamar(){
        Call<List<HomeModel>> call = RetrofitClient.getInstance().getMyApi().getKamar();
        call.enqueue(new Callback<List<HomeModel>>() {
            @Override
            public void onResponse(Call<List<HomeModel>> call, Response<List<HomeModel>> response) {
                List<HomeModel> HomeModelList = response.body();
                HomeAdapter adapter =  new HomeAdapter(getContext(), HomeModelList);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<HomeModel>> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}
