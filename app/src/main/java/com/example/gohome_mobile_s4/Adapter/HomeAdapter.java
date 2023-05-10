package com.example.gohome_mobile_s4.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Viewholder> {
    private List<HomeModel> HomeModelList;
    public HomeAdapter(List<HomeModel>HomeModelList){
        this.HomeModelList = HomeModelList;
    }

    @NonNull
    @Override
    public HomeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, parent, false);
        return new HomeAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.Viewholder holder, int position) {
        int item_image = HomeModelList.get(position).getItem_image();
        String jKamar = HomeModelList.get(position).getJkamar();
        String harga = HomeModelList.get(position).getHarga();
    }

    @Override
    public int getItemCount() {
        if (HomeModelList != null) {
            return HomeModelList.size();
        }
        return 0;
    }
    public  class  Viewholder extends RecyclerView.ViewHolder{
        private ImageView item_image;
        private TextView Jkamar;
        private TextView harga_room;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            Jkamar = itemView.findViewById(R.id.jKamar);
            harga_room = itemView.findViewById(R.id.harga);


        }

        public void setData(int resource, String jKamar, String harga) {
            item_image.setImageResource(resource);
            Jkamar.setText(jKamar);
            harga_room.setText(harga);
        }
    }
}
