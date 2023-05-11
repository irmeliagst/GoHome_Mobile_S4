package com.example.gohome_mobile_s4;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gohome_mobile_s4.Adapter.HomeAdapter;
import com.example.gohome_mobile_s4.Model.HomeModel;

import java.util.ArrayList;
import java.util.List;


public class homeFragment extends Fragment {

    public homeFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private HomeAdapter myAdapter;
    private List<HomeModel> HomeModelList;
    LinearLayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.kamar_tampil);
        // Inisialisasi data
        HomeModelList = new ArrayList<>();
        HomeModelList.add(new HomeModel(R.drawable.imgsiti, "Suite Room", "500.000"));
        HomeModelList.add(new HomeModel(R.drawable.imgsiti, "Suite Room", "500.000"));
        HomeModelList.add(new HomeModel(R.drawable.imgsiti, "Suite Room", "500.000"));
        HomeModelList.add(new HomeModel(R.drawable.imgsiti, "Suite Room", "500.000"));
        HomeModelList.add(new HomeModel(R.drawable.imgsiti, "Suite Room", "500.000"));
        HomeModelList.add(new HomeModel(R.drawable.imgsiti, "Suite Room", "500.000"));
        HomeModelList.add(new HomeModel(R.drawable.imgsiti, "Suite Room", "500.000"));
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new HomeAdapter(HomeModelList);
        recyclerView.setAdapter(myAdapter);


        return view;
    }
}