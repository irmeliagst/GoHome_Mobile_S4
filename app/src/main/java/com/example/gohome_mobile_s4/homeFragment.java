package com.example.gohome_mobile_s4;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.gohome_mobile_s4.Model.Tanggal;
import com.example.gohome_mobile_s4.Model.kamar.KamarTersedia;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homeFragment extends Fragment {


    Context context;

    private RecyclerView recyclerView;
    private HomeAdapter myAdapter;
    private List<HomeModel> kamarList;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    private LinearLayoutManager layoutManager;


    public homeFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.kamar_tampil);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        getKamar();
        return  view;
    }

    private void getKamar() {
        Call<List<HomeModel>> call = RetrofitClient.getInstance().getMyApi().getKamar();
        call.enqueue(new Callback<List<HomeModel>>() {
            @Override
            public void onResponse(Call<List<HomeModel>> call, Response<List<HomeModel>> response) {
                List<HomeModel> HomeModelList = response.body();
                System.out.println(HomeModelList);
                HomeAdapter adapter = new HomeAdapter(getContext(), HomeModelList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<HomeModel>> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }

}
