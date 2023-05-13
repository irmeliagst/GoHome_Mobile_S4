package com.example.gohome_mobile_s4.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gohome_mobile_s4.Model.TransaksiModel;
import com.example.gohome_mobile_s4.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class transaksiAdapter extends RecyclerView.Adapter <transaksiAdapter.Viewholder>{
    private List<TransaksiModel> transaksiModelList;
    public transaksiAdapter(Context context, List<TransaksiModel>transaksiModelList){
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
        final TransaksiModel item = transaksiModelList.get(position);
        String checkin = item.getTanggal_chekin();
        String checkout = item.getTanggal_chekout();
        holder.jenis_kamar.setText(transaksiModelList.get(position).getJenis_kamar());
        holder.total.setText(transaksiModelList.get(position).getTotal());
        holder.tanggal_chekin.setText(checkin);
        holder.tanggal_chekout.setText(checkout);
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


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            gambar_kamar = itemView.findViewById(R.id.imageview);
            jenis_kamar = itemView.findViewById(R.id.textview);
            total = itemView.findViewById(R.id.textview2);
            tanggal_chekin = itemView.findViewById(R.id.textview3);
            tanggal_chekout = itemView.findViewById(R.id.textview4);
        }
    }
}