package com.example.gohome_mobile_s4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gohome_mobile_s4.Adapter.HomeAdapter;
import com.example.gohome_mobile_s4.Adapter.menungguAdapter;
import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.MenungguModel;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MenungguFragment extends Fragment {
    private RecyclerView recyclerView;
    private menungguAdapter myAdapter;
    private List<MenungguModel> menungguModelList;
    LinearLayoutManager layoutManager;
    public MenungguFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menunggu, container, false);
        recyclerView = view.findViewById(R.id.menunggu_tampil);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        getMenunggu();
        return view;
    }

    private void getMenunggu(){
        Call<List<MenungguModel>> call = RetrofitClient.getInstance().getMyApi().getMenunggu();
        call.enqueue(new Callback<List<MenungguModel>>() {
            @Override
            public void onResponse(Call<List<MenungguModel>> call, Response<List<MenungguModel>> response) {
                List<MenungguModel> menungguModelList = response.body();
                menungguAdapter adapter =  new menungguAdapter(getContext(), menungguModelList);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<MenungguModel>> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
}}