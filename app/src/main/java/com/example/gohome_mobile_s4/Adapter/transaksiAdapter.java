package com.example.gohome_mobile_s4.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gohome_mobile_s4.Model.transaksiNik.DataItem;
import com.example.gohome_mobile_s4.R;
import com.example.gohome_mobile_s4.SesionManager;
import com.example.gohome_mobile_s4.retrofit.ApiInterface;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class transaksiAdapter extends RecyclerView.Adapter <transaksiAdapter.Viewholder>{
    SesionManager sesionManager;
    private final List<DataItem> transaksiModelList;
    DataItem dataItem;
    ApiInterface apiInterface;
    public transaksiAdapter(Context context, List<DataItem>transaksiModelList){

        sesionManager = new SesionManager(context);
        apiInterface = RetrofitClient.getInstance().getMyApi();
        this.transaksiModelList = transaksiModelList;

    }
    @NonNull
    @Override
    public transaksiAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaksi_item, parent, false);
        return new transaksiAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull transaksiAdapter.Viewholder holder, int position) {
        Picasso.get().load("http://192.168.43.236:8000/images/"+transaksiModelList.get(position).getGambar_kamar()).into(holder.gambar_kamar);
        final DataItem transaksi = transaksiModelList.get(position);
        final String NIK = sesionManager.getUserDetail().get(SesionManager.NIK);
        final String Nik = String.valueOf(transaksiModelList.get(position).getNik());
        String tanggal_checkin = transaksi.getTanggalCheckin();
        String tanggal_checkout = transaksi.getTanggalCheckout();
        holder.jenis_kamar.setText(transaksiModelList.get(position).getJenisKamar());
        holder.status.setText(transaksiModelList.get(position).getStatus());
        holder.total.setText(String.valueOf(transaksiModelList.get(position).getTotal()));
        holder.tanggal_chekin.setText(tanggal_checkin);
        holder.tanggal_chekout.setText(tanggal_checkout);

    }

    @Override
    public int getItemCount() {
        if (transaksiModelList != null) {
            return transaksiModelList.size();
        }
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        private ImageView gambar_kamar;
        private TextView jenis_kamar;
        private TextView total;
        private TextView tanggal_chekin;
        private TextView tanggal_chekout;
        private TextView status;
        SesionManager sesionManager;
        ApiInterface apiInterface;
        DataItem dataItem;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            sesionManager = new SesionManager(itemView.getContext());
            apiInterface = RetrofitClient.getInstance().getMyApi();
            gambar_kamar = itemView.findViewById(R.id.imageview);
            jenis_kamar = itemView.findViewById(R.id.textview);
            total = itemView.findViewById(R.id.textview2);
            tanggal_chekin = itemView.findViewById(R.id.textview3);
            tanggal_chekout = itemView.findViewById(R.id.textview4);
            status = itemView.findViewById(R.id.textview5);
        }
    }
}