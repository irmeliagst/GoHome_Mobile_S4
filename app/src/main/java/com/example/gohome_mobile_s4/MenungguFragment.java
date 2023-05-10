package com.example.gohome_mobile_s4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gohome_mobile_s4.Adapter.menungguAdapter;
import com.example.gohome_mobile_s4.Model.MenungguModel;

import java.util.ArrayList;
import java.util.List;


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
        // Inisialisasi data
        menungguModelList = new ArrayList<>();
        menungguModelList.add(new MenungguModel(R.drawable.imgsiti, "Suite Room", "500.000", "diproses"));
        menungguModelList.add(new MenungguModel(R.drawable.imgsiti, "Suite Room", "500.000", "diproses"));
        menungguModelList.add(new MenungguModel(R.drawable.imgsiti, "Suite Room", "500.000", "diproses"));
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new menungguAdapter(menungguModelList);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}