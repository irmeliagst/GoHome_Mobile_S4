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
import com.example.gohome_mobile_s4.Model.transaksi.TransaksiModelItem;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TransaksiFragment extends Fragment {

    private RecyclerView recyclerView;
    private transaksiAdapter myAdapter;
    private List<TransaksiModelItem> transaksiModelList ;
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
        Call<List<TransaksiModelItem>> call = RetrofitClient.getInstance().getMyApi().getTransaksi();
       call.enqueue(new Callback<List<TransaksiModelItem>>() {
           @Override
           public void onResponse(Call<List<TransaksiModelItem>> call, Response<List<TransaksiModelItem>> response) {
               List<TransaksiModelItem> transaksiModelList = response.body();
               transaksiAdapter adapter =  new transaksiAdapter(getContext(), transaksiModelList);
               recyclerView.setAdapter(adapter);
               System.out.println(response.body().get(0).getTanggalCheckin());
               for (TransaksiModelItem transaksi : transaksiModelList) {
                   // Dapatkan tanggal dari objek transaksi
                   String tanggal_checkin = transaksi.getTanggalCheckin();
                   String tanggal_checkout = transaksi.getTanggalCheckout();
//                   String total = transaksi.getTotal();

                   // Lakukan sesuatu dengan tanggal, seperti menampilkannya atau memprosesnya lebih lanjut
                   System.out.println("Tanggal transaksi checkin: " + tanggal_checkin);
                   System.out.println("Tanggal transaksi checkout: " + tanggal_checkout);
//                   System.out.println("Total: " + total);
               }
           }

           @Override
           public void onFailure(Call<List<TransaksiModelItem>> call, Throwable t) {

           }
       });
    }
}