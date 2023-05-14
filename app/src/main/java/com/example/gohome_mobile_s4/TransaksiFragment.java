package com.example.gohome_mobile_s4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gohome_mobile_s4.Adapter.transaksiAdapter;
import com.example.gohome_mobile_s4.Model.transaksiNik.DataItem;
import com.example.gohome_mobile_s4.Model.transaksiNik.TransaksiNik;
import com.example.gohome_mobile_s4.retrofit.ApiInterface;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TransaksiFragment extends Fragment {

    private RecyclerView recyclerView;
    private transaksiAdapter myAdapter;
    SesionManager sesionManager;
    ApiInterface apiInterface;
    DataItem dataItem;
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
        sesionManager = new SesionManager(requireContext());
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        String nik = sesionManager.getUserDetail().get(SesionManager.NIK);
        apiInterface = RetrofitClient.getInstance().getMyApi();
        postTransaksi(nik);
        return view;
    }
    private void postTransaksi(String nik) {
        Call <TransaksiNik> call = RetrofitClient.getInstance().getMyApi().postTransaksi(nik);
       call.enqueue(new Callback<TransaksiNik>() {
           @Override
           public void onResponse(Call<TransaksiNik> call, Response<TransaksiNik> response) {
               if (response.isSuccessful() && response.body() != null && response.body().isSuccess()){
                   List<DataItem> transaksiModelList = response.body().getData();
                   transaksiAdapter adapter =  new transaksiAdapter(getContext(), transaksiModelList);
                   recyclerView.setAdapter(adapter);

                   // Tambahkan System.out.println() untuk melihat data berhasil terpanggil
//                   System.out.println("Data berhasil terpanggil:");
                   for (DataItem transaksi : transaksiModelList) {
                       System.out.println("ID Transaksi: " + transaksi.getNik());
                       System.out.println("Tanggal Checkin: " + transaksi.getTanggalCheckin());
                       System.out.println("Tanggal Checkout: " + transaksi.getTanggalCheckout());
                       // Tambahkan informasi lainnya sesuai kebutuhan
                   }
               }
           }

           @Override
           public void onFailure(Call<TransaksiNik> call, Throwable t) {
               Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
           }
       });
    }
}