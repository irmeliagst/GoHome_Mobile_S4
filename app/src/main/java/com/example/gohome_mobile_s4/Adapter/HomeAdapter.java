package com.example.gohome_mobile_s4.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gohome_mobile_s4.BookingActivity;
import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Viewholder> {
    private Context context;
    int idKamar;
    private List<HomeModel> HomeModelList;
    public HomeAdapter(Context context, List<HomeModel> HomeModelList){
        this.context = context;
        this.HomeModelList = HomeModelList;
    }

    @NonNull
    @Override
    public HomeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kamar_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load("http://192.168.43.236:8000/images/"+HomeModelList.get(position).getGambar_kamar()).into(holder.item_image);
       holder.jenis_kamar.setText(HomeModelList.get(position).getjenis_kamar());
       holder.harga.setText(""+HomeModelList.get(position).getHarga());
        holder.id_kamar.setText(""+HomeModelList.get(position).getId_kamar()); //string concatenation(cari sendiri di google)
        holder.deskripsi.setText(HomeModelList.get(position).getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(v.getContext(), BookingActivity.class);
                intent.putExtra("id_kamar", HomeModelList.get(position).getId_kamar());
                System.out.println("id_kamar "+HomeModelList.get(position).getId_kamar());

                intent.putExtra("jenis_kamar", HomeModelList.get(position).getjenis_kamar());
                System.out.println("jenis_kamar "+HomeModelList.get(position).getjenis_kamar());

                intent.putExtra("harga", HomeModelList.get(position).getHarga());
                System.out.println("harga "+HomeModelList.get(position).getHarga());

                intent.putExtra("nomer_kamar", HomeModelList.get(position).getNomer_kamar());
                System.out.println("nomer_kamar "+HomeModelList.get(position).getNomer_kamar());

                System.out.println("item_image"+HomeModelList.get(position).getGambar_kamar());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (HomeModelList != null) {
            return HomeModelList.size();
        }
        return 0;
    }


    public  static class  Viewholder extends RecyclerView.ViewHolder {
        public ImageView item_image;
        public TextView jenis_kamar, harga, id_kamar, deskripsi;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            jenis_kamar = itemView.findViewById(R.id.jKamar);
            harga= itemView.findViewById(R.id.harga);
            id_kamar= itemView.findViewById(R.id.id_kamar);
            deskripsi= itemView.findViewById(R.id.deskripsi);
        }

    }
}
