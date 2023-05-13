package com.example.gohome_mobile_s4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gohome_mobile_s4.Adapter.transaksiAdapter;
import com.example.gohome_mobile_s4.Model.TransaksiModel;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TransaksiFragment extends Fragment {

    private RecyclerView recyclerView;
    private transaksiAdapter myAdapter;
    private List<TransaksiModel> transaksiModelList ;
    LinearLayoutManager layoutManager;
    public TransaksiFragment() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        recyclerView = view.findViewById(R.id.history);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        getTransaksi();
        return view;
    }

    private void getTransaksi() {
        Call<List<TransaksiModel>> call = RetrofitClient.getInstance().getMyApi().getTransaksi();
       call.enqueue(new Callback<List<TransaksiModel>>() {
           @Override
           public void onResponse(Call<List<TransaksiModel>> call, Response<List<TransaksiModel>> response) {
               List<TransaksiModel> transaksiModelList = response.body();
               transaksiAdapter adapter =  new transaksiAdapter(getContext(), transaksiModelList);
               recyclerView.setAdapter(adapter);
           }

           @Override
           public void onFailure(Call<List<TransaksiModel>> call, Throwable t) {

           }
       });
    }
}