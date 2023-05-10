package com.example.gohome_mobile_s4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gohome_mobile_s4.Adapter.CheckinAdapter;
import com.example.gohome_mobile_s4.Adapter.CheckoutAdapter;
import com.example.gohome_mobile_s4.Model.CheckinModel;
import com.example.gohome_mobile_s4.Model.CheckoutModel;

import java.util.ArrayList;
import java.util.List;


public class CheckinFragment extends Fragment {
    private RecyclerView recyclerView;
    private CheckinAdapter myAdapter;
    private List<CheckinModel> checkinModelList;
    LinearLayoutManager layoutManager;

    public CheckinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);
        recyclerView = view.findViewById(R.id.checkout_tampil);
        // Inisialisasi data
        checkinModelList = new ArrayList<>();
        checkinModelList.add(new CheckinModel(R.drawable.imgsiti, "Suite Room", "500.000", "Check in"));
        checkinModelList.add(new CheckinModel(R.drawable.imgsiti, "Suite Room", "500.000", "Check in"));
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new CheckinAdapter(checkinModelList);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}