package com.example.gohome_mobile_s4.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gohome_mobile_s4.DetailKamarActivity;
import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.R;
import com.example.gohome_mobile_s4.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Viewholder> {
    private Context context;
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
    public void onBindViewHolder(@NonNull HomeAdapter.Viewholder holder, int position) {
       holder.jenis_kamar.setText(HomeModelList.get(position).getjenis_kamar());
       holder.harga.setText(HomeModelList.get(position).getHarga());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(v.getContext(), DetailKamarActivity.class);
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
        public TextView jenis_kamar, harga;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            jenis_kamar = itemView.findViewById(R.id.jKamar);
            harga= itemView.findViewById(R.id.harga);
        }

    }
}
